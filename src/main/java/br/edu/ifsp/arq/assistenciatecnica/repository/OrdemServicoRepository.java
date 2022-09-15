package br.edu.ifsp.arq.assistenciatecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.arq.assistenciatecnica.domain.model.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>{

}
