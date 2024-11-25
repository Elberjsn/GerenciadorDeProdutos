package com.elberjsn.gerenciador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elberjsn.gerenciador.model.Fornecedor;


public interface FornecedorRepository  extends JpaRepository<Fornecedor,Long>{
    List<Fornecedor> findByNomeContainingIgnoreCase(String nome);
    List<Fornecedor> findByProdutosNomeContainingIgnoreCase(String nome);
}
