package br.com.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.helpdesk.domain.Chamado;
import br.com.helpdesk.domain.Cliente;
import br.com.helpdesk.domain.Tecnico;
import br.com.helpdesk.domain.enums.Perfil;
import br.com.helpdesk.domain.enums.Prioridade;
import br.com.helpdesk.domain.enums.Status;
import br.com.helpdesk.repositories.ChamadoRepository;
import br.com.helpdesk.repositories.ClienteRepository;
import br.com.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaDB() {
	    Tecnico tec1 = new Tecnico(null, "Valdir cezar", "51715847024", "valdir@mail.com", "123");
	    tec1.addPerfil(Perfil.ADMIN);
	    
	    Cliente cli1 = new Cliente(null, "Marcos Gabriel", "95252949000", "marcos@mail.com", "123");
	    
	    Chamado c1 = new Chamado(null, null, null, Prioridade.MEDIA, Status.ANDAMENTO, "chamado 01", null, tec1, cli1);
	    
	    tecnicoRepository.save(tec1);
	    clienteRepository.save(cli1);
	    chamadoRepository.save(c1);
	}

}
