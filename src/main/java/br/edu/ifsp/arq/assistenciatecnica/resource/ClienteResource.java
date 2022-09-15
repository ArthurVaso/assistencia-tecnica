package br.edu.ifsp.arq.assistenciatecnica.resource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.assistenciatecnica.domain.model.Cliente;
import br.edu.ifsp.arq.assistenciatecnica.domain.model.Endereco;
import br.edu.ifsp.arq.assistenciatecnica.repository.ClienteRepository;
import br.edu.ifsp.arq.assistenciatecnica.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> listar(){
		return clienteRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente criar(
			@Valid @RequestBody Cliente cliente, 
			HttpServletResponse response) {
		return clienteRepository.save(cliente);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Cliente> buscarPorCodigo(@PathVariable Long codigo){
		Optional<Cliente> cliente = clienteRepository.findById(codigo);
		if(cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		clienteRepository.deleteById(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long codigo, @Valid @RequestBody Cliente cliente){
		Cliente clienteSalva = clienteService.atualizar(codigo, cliente);
		
		return ResponseEntity.ok(clienteSalva);
	}
	
	@PutMapping("/{codigo}/endereco")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarEndereco(@PathVariable Long codigo, @RequestBody Endereco endereco){
		clienteService.atualizarEndereco(codigo, endereco);
	}
	
	@PutMapping("/{codigo}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarClienteAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo){
		clienteService.atualizarClienteAtivo(codigo, ativo);
	}
	
}
