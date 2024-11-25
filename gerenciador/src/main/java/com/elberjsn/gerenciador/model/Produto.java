package com.elberjsn.gerenciador.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor


public class Produto implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O Nome do produto não pode ser vazio!")
    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidadeEstoque;
    private String urlImagem;
    private LocalDate validade;


    @ManyToMany(mappedBy = "produtos")
    @NotNull(message = "O Fornecedor do produto não pode ser vazio!")
    private Set<Fornecedor> fornecedor;

    @OneToMany
    @JoinColumn(name = "produtos")
    @NotNull(message = "A Categoria do produto não pode ser vazio!")
    private List<Categoria> categoria;
}
