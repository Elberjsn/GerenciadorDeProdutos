package com.elberjsn.gerenciador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elberjsn.gerenciador.model.Contato;


public interface ContatoRepository  extends JpaRepository<Contato,Long> {
    List<Contato> findByFornecedorId(Long idForn);
    List<Contato> findByFornecedorNomeContainingIgnoringCase(String nome);

}
