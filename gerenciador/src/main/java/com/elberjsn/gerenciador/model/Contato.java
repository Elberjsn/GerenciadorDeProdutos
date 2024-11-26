package com.elberjsn.gerenciador.model;


import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Contato {

    @Id
    private Long id;
    
    @NotNull(message = "O Contato do Fornecedor não pode ser vazio")
    private String telefone;

    private String email;

    private String endereco;

    @ManyToMany(mappedBy = "contatos")
    Set<Fornecedor> fornecedor;
}
