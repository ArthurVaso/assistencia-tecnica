package br.edu.ifsp.arq.assistenciatecnica.resource;

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

import br.edu.ifsp.arq.assistenciatecnica.domain.model.FormaPagamento;
import br.edu.ifsp.arq.assistenciatecnica.repository.FormaPagamentoRepository;
import br.edu.ifsp.arq.assistenciatecnica.service.FormaPagamentoService;

@RestController
@RequestMapping("/formas-pagamento")
public class FormaPagamentoResource {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	@Autowired
	private FormaPagamentoService formaPagamentoService;
	
	@GetMapping
	public List<FormaPagamento> listar(){
		return formaPagamentoRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FormaPagamento criar(
			@Valid @RequestBody FormaPagamento formaPagamento, 
			HttpServletResponse response) {
		return formaPagamentoRepository.save(formaPagamento);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<FormaPagamento> buscarPorCodigo(@PathVariable Long codigo){
		Optional<FormaPagamento> formaPagamento = formaPagamentoRepository.findById(codigo);
		if(formaPagamento.isPresent()) {
			return ResponseEntity.ok(formaPagamento.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		formaPagamentoRepository.deleteById(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<FormaPagamento> atualizar(@PathVariable Long codigo, @Valid @RequestBody FormaPagamento formaPagamento){
		FormaPagamento formaPagamentoSalva = formaPagamentoService.atualizar(codigo, formaPagamento);
		
		return ResponseEntity.ok(formaPagamentoSalva);
	}
}
