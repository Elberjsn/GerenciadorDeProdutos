package com.elberjsn.gerenciador.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
    private LocalDate ultimaAtualizacao;


    @ManyToMany
    @JoinTable(name = "forn_dos_prd",joinColumns={@JoinColumn(name = "produto_id")},inverseJoinColumns={@JoinColumn(name = "fornecedor_id")})
    private List<Fornecedor> fornecedoresPrd;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "produtos")
    private Categoria categoria;
    
}
