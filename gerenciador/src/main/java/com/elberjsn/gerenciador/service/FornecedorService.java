package com.elberjsn.gerenciador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elberjsn.gerenciador.model.Fornecedor;
import com.elberjsn.gerenciador.repository.FornecedorRepository;

@Service
public class FornecedorService {
    
    @Autowired
    FornecedorRepository fornecedorRepository;

    public Fornecedor salvarFornecedor(Fornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }
    public List<Fornecedor> buscaFornecedores(){
        return fornecedorRepository.findAll();
    }
    public List<Fornecedor> buscaFornecedorPorNome(String nome){
        return fornecedorRepository.findByNomeContainingIgnoreCase(nome);
    }
    public List<Fornecedor> buscarFornecedorPorProduto(String nomeprd){
        return fornecedorRepository.findByProdutosNomeContainingIgnoreCase(nomeprd);
    }
    public Fornecedor buscaFornecedorPorId(Long id){
        return fornecedorRepository.findById(id).get();
    }

    public Fornecedor editaFornecedor(Fornecedor fornecedor){
        var forne = buscaFornecedorPorId(fornecedor.getId());

        forne.setNome(fornecedor.getNome());

        return fornecedorRepository.save(forne);
    }
    public void deletarFornecedor(Fornecedor fornecedor){
        fornecedorRepository.delete(fornecedor);
    }


}
