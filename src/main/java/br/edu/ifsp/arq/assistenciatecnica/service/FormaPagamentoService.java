package br.edu.ifsp.arq.assistenciatecnica.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.assistenciatecnica.domain.model.FormaPagamento;
import br.edu.ifsp.arq.assistenciatecnica.repository.FormaPagamentoRepository;

@Service
public class FormaPagamentoService {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	public FormaPagamento atualizar(Long codigo, FormaPagamento formaPagamento) {
		FormaPagamento formaPagamentoSalva = buscarFormaPagamentoPeloCodigo(codigo);
		
		BeanUtils.copyProperties(formaPagamento, formaPagamentoSalva, "codigo");
		
		return this.formaPagamentoRepository.save(formaPagamentoSalva);
	}
	
	private FormaPagamento buscarFormaPagamentoPeloCodigo(Long codigo) {
		FormaPagamento formaPagamentoSalva = this.formaPagamentoRepository
				.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		
		return formaPagamentoSalva;
	}

}
