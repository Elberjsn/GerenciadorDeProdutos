package com.elberjsn.gerenciador.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elberjsn.gerenciador.model.Fornecedor;
import com.elberjsn.gerenciador.service.FornecedorService;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

     @Autowired
     FornecedorService fornecedorService;

    @GetMapping(path = {"/","/{id}"})
    public ResponseEntity<Fornecedor> indexFornecedor(@PathVariable Optional<String> id) {
       if (id.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).build();
       }else{
          return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.buscaFornecedorPorId(Long.parseLong(id.get())));
       }
    }
    
    @GetMapping("/buscar/{metodo}")
    public ResponseEntity<List<Fornecedor>> buscarFonecedores(@PathVariable Optional<String> metodo,@RequestParam String param) {
        
          switch (metodo.get()) {
               case "nome":
                    return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.buscaFornecedorPorNome(param));
               case "produto":
                    return ResponseEntity.status(HttpStatus.OK).body(fornecedorService.buscarFornecedorPorProduto(param));
               case "id":
                    var ids= List.of(fornecedorService.buscaFornecedorPorId(Long.parseLong(param)));
                    return ResponseEntity.status(HttpStatus.OK).body(ids);          
               default:
                   
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build()            ;   
          }
          
    }
    
    
}
