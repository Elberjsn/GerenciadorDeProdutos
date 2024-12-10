package com.elberjsn.gerenciador.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Fornecedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O Nome do Fornecedor não pode ser vazio")
    @NonNull
    private String nome;

    @OneToMany(mappedBy = "fornecedorContatos")
    @NotNull(message = "O Contato do Fornecedor não pode ser vazio")
    List<Contato> contatos;

    @JsonIgnore
    @ManyToMany(mappedBy = "fornecedoresPrd")
    List<Produto> prdsFornecedore;
    

}
