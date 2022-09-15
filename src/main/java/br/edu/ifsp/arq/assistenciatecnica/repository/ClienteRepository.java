package br.edu.ifsp.arq.assistenciatecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;import br.edu.ifsp.arq.assistenciatecnica.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
