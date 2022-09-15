package br.edu.ifsp.arq.assistenciatecnica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.assistenciatecnica.domain.model.Cliente;
import br.edu.ifsp.arq.assistenciatecnica.domain.model.OrdemServico;
import br.edu.ifsp.arq.assistenciatecnica.repository.ClienteRepository;
import br.edu.ifsp.arq.assistenciatecnica.repository.OrdemServicoRepository;
import br.edu.ifsp.arq.assistenciatecnica.service.exception.ClienteInexistenteouInativaException;

@Service
public class OrdemServicoService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	public OrdemServico salvar(OrdemServico ordemServico) {
		Optional<Cliente> cliente = this.clienteRepository.findById(ordemServico.getCliente().getCodigo());
		if (!cliente.isPresent()) {
			throw new ClienteInexistenteouInativaException();
		}
		
		return ordemServicoRepository.save(ordemServico);
	}
	
}
