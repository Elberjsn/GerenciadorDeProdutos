package com.elberjsn.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elberjsn.gerenciador.model.Contato;

public interface ContatoRepository  extends JpaRepository<Contato,Long> {

}
