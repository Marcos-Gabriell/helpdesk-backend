package br.com.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.helpdesk.domain.Pessoa;
import br.com.helpdesk.domain.dtos.ClienteDTO;
import br.com.helpdesk.domain.Cliente;
import br.com.helpdesk.repositories.PessoaRepository;
import br.com.helpdesk.repositories.ClienteRepository;
import br.com.helpdesk.services.exceptions.DataIntegerityViolationException;
import br.com.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private PessoaRepository pessoaRepository;

	public Cliente findByid(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! id: " + id));
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente create(ClienteDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfEEmail(objDTO);
		Cliente newobj = new Cliente(objDTO);
		return repository.save(newobj);
	}

	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		objDTO.setId(id);
		Cliente oldObj = findByid(id);
		validaPorCpfEEmail(objDTO);
		oldObj = new Cliente(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Cliente obj = findByid(id);
		if(obj.getChamados().size() > 0) {
			throw new DataIntegerityViolationException("O cliente possui ordens de serviço e não pode ser deletado!");
		} 
		repository.deleteById(id);
	}

	private void validaPorCpfEEmail(ClienteDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegerityViolationException("CPF já cadastrado no sistema!");
		}

		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegerityViolationException("E-mail já cadastrado no sistema!");
		}
	}

}
