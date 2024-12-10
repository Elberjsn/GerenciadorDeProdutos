package com.elberjsn.gerenciador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elberjsn.gerenciador.model.Categoria;
import com.elberjsn.gerenciador.service.CategoriaService;
import com.fasterxml.jackson.databind.ObjectMapper;






@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;
    
    @GetMapping("/")
    public ResponseEntity<List<Categoria>> indexCategoria() {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.buscaCategorias());
    }
    @GetMapping("/buscar/nome")
    public ResponseEntity<List<Categoria>> buscarPorNome(@RequestParam String valor) {
        List<Categoria> busca = categoriaService.buscarCategoriasNome(valor);
        
        return ResponseEntity.status(HttpStatus.OK).body(busca);
    }

    @PostMapping("/novo")
    public ResponseEntity<Categoria> novaCategoria(@RequestBody String entity) {
        Categoria categoria = jsonObj(entity);
        if (categoria != null) {
            Categoria cat = categoriaService.savarCategoria(categoria);
            return ResponseEntity.status(HttpStatus.CREATED).body(cat);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PutMapping("editar/{id}")
    public ResponseEntity<Categoria> editarCategoria(@PathVariable String id, @RequestBody String entity) {
        Categoria cat = jsonObj(entity);
        cat.setId(Long.parseLong(id));

        cat= categoriaService.atualizarCategoria(cat);
        
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(cat);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarCategoria(@PathVariable String id){
        
        Categoria cat = categoriaService.buscarCategoriaPorId(Long.parseLong(id));

        if (cat != null) {
            categoriaService.deletarCategoria(cat);
            return ResponseEntity.status(HttpStatus.OK).build();
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
       
    } 


    public Categoria jsonObj(String json){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Categoria cat =objectMapper.readValue(json, Categoria.class);
            
            return cat;
        } catch (Exception e) {
            return null;
        }
    }
    
    
    
    

}
