package br.edu.ifsp.arq.assistenciatecnica.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.assistenciatecnica.domain.model.Cliente;
import br.edu.ifsp.arq.assistenciatecnica.domain.model.Endereco;
import br.edu.ifsp.arq.assistenciatecnica.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente atualizar(Long codigo, Cliente cliente) {
		Cliente clienteSalva = buscarClientePeloCodigo(codigo);
		
		BeanUtils.copyProperties(cliente, clienteSalva, "codigo");
		
		return this.clienteRepository.save(clienteSalva);
	}
	
	public void atualizarEndereco(Long codigo, Endereco endereco) {
		Cliente clienteSalva = buscarClientePeloCodigo(codigo);
		
		clienteSalva.setEndereco(endereco);
		
		clienteRepository.save(clienteSalva);
	}
	
	public void atualizarClienteAtivo(Long codigo, Boolean ativo) {
		Cliente clienteSalva = buscarClientePeloCodigo(codigo);
		
		clienteSalva.setAtivo(ativo);
		
		clienteRepository.save(clienteSalva);
	}
	
	private Cliente buscarClientePeloCodigo(Long codigo) {
		Cliente clienteSalva = this.clienteRepository
				.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		
		return clienteSalva;
	}
}
