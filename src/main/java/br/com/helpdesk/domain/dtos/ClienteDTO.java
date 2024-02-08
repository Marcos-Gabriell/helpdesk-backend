package br.com.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import br.com.helpdesk.domain.Cliente;
import br.com.helpdesk.domain.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Integer id;
    
    @NotNull(message = "o campo NOME é requerido")
    protected String nome;
    
    @NotNull(message = "o campo CPF é requerido")
    protected String cpf;
    
    @NotNull(message = "o campo EMAIL é requerido")
    protected String email;
    
    @NotNull(message = "o campo SENHA é requerido")
    protected String senha;
    protected Set<Integer> perfis = new HashSet<>();
    protected LocalDate dataCriacao = LocalDate.now();

    public ClienteDTO(Cliente obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(Perfil::getCodigo).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
        addPerfil(Perfil.CLIENTE);
    }

    private void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(Perfil::toEnum).collect(Collectors.toSet());
    }
}
