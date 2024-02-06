package br.com.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{

}
