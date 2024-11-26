package com.elberjsn.gerenciador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.elberjsn.gerenciador.model.Categoria;
import com.elberjsn.gerenciador.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria savarCategoria(Categoria cat){
        return categoriaRepository.save(cat);
    }
    public Categoria buscarCategoriaPorId(Long id){
        var cat = categoriaRepository.findById(id);

        if (cat.isEmpty()) {
            try {
                throw new NotFoundException();
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        return categoriaRepository.findById(id).get();
    }
    public List<Categoria> buscaCategorias(){
        return categoriaRepository.findAll();
    }
    public List<Categoria> buscarCategoriasNome(String nome){
        return categoriaRepository.findByNomeContainingIgnoringCase(nome);
    }
    public Categoria atualizarCategoria(Categoria cat){
        var buscaCat = buscarCategoriaPorId(cat.getId());
        buscaCat.setNome(cat.getNome());
        return categoriaRepository.save(buscaCat);
    }
    public void deletarCategoria(Categoria cat){
        categoriaRepository.delete(cat);
    }
}
