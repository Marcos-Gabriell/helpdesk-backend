package br.com.helpdesk.helpdesk.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import br.com.helpdesk.helpdesk.domain.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pessoa {

    protected Integer id;
    protected String nome;
    protected String cpf;
    protected String email;
    protected String senha;
    protected Set<Perfil> perfis = new HashSet<>();
    protected LocalDate dataCriacao = LocalDate.now();
}
