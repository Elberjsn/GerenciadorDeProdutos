package com.elberjsn.gerenciador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elberjsn.gerenciador.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    List<Categoria> findByNomeContainingIgnoringCase(String nome);
}
