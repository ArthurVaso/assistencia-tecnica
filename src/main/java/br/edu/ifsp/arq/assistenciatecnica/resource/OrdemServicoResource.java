package br.edu.ifsp.arq.assistenciatecnica.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.assistenciatecnica.domain.model.OrdemServico;
import br.edu.ifsp.arq.assistenciatecnica.repository.OrdemServicoRepository;
import br.edu.ifsp.arq.assistenciatecnica.service.OrdemServicoService;

@RestController
@RequestMapping("/ordem-servico")
public class OrdemServicoResource {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	private OrdemServicoService ordemServicoService;
	
	@GetMapping
	public List<OrdemServico> listar(){
		return ordemServicoRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<OrdemServico> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(codigo);
		if(ordemServico.isPresent()) {
			return ResponseEntity.ok(ordemServico.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdemServico criar(@Valid @RequestBody OrdemServico ordemServico) {
		return ordemServicoService.salvar(ordemServico);
	}
	
}
