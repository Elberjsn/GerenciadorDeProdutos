package com.elberjsn.gerenciador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.elberjsn.gerenciador.model.Categoria;
import com.elberjsn.gerenciador.repository.CategoriaRepository;
import com.elberjsn.gerenciador.repository.FornecedorRepository;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    FornecedorRepository fornecedorRepository;

    @Override
    public void run(String... args) throws Exception {
        
        Categoria cat = new Categoria("Cat1");
        Categoria cat2 = new Categoria("Cat2");
        Categoria cat3 = new Categoria("Cat3");

       
        categoriaRepository.saveAll(List.of(cat,cat2,cat3));
    }


}
