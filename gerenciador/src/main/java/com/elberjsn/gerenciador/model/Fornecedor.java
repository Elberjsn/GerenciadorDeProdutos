package com.elberjsn.gerenciador.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Fornecedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O Nome do Fornecedor não pode ser vazio")
    private String nome;

    @ManyToMany
    @NotNull(message = "O Contato do fFornecedor não pode ser vazio")
    @JoinTable(name = "contatos_forn",joinColumns =@JoinColumn(name="contato_id"),inverseJoinColumns = @JoinColumn(name="fornecedor_id"))
    Set<Contato> contatos;

    @ManyToMany
    @JoinTable(name = "produtos_forn",joinColumns =@JoinColumn(name="produto_id"),inverseJoinColumns = @JoinColumn(name="fornecedor_id"))
    Set<Produto> produtos;
    

}
