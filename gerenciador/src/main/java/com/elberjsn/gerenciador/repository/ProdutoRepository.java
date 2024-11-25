package com.elberjsn.gerenciador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elberjsn.gerenciador.model.Produto;

public interface ProdutoRepository  extends JpaRepository<Produto,Long> {
    List<Produto> findByNomeContainingIgnoreCase(String nome);
}
