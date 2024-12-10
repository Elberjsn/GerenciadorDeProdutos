package com.elberjsn.gerenciador.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elberjsn.gerenciador.model.Produto;
import com.elberjsn.gerenciador.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public Produto salvarProduto(Produto prd){
        prd.setUltimaAtualizacao(LocalDate.now());
        return produtoRepository.save(prd);
    }
    public List<Produto> buscarProdutos(){
        return produtoRepository.findAll();
    }
    public Produto buscarProdutoPorId(Long id){
        return produtoRepository.findById(id).get();
    }
    public List<Produto> buscarProdutosPorNome(String nome){
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }
    public List<Produto> buscarProdutosPorFornecedor(String nome){
        return produtoRepository.findByCategoriaNomeContainingIgnoreCase(nome);
    }
    public Produto editaProduto(Produto prd){
        var produto = buscarProdutoPorId(prd.getId());

        produto.setDescricao(prd.getDescricao());
        produto.setNome(prd.getNome());
        produto.setPreco(prd.getPreco());
        produto.setQuantidadeEstoque(prd.getQuantidadeEstoque());
        produto.setUrlImagem(prd.getUrlImagem());
        produto.setValidade(prd.getValidade());
        produto.setUltimaAtualizacao(prd.getUltimaAtualizacao());


        return produtoRepository.save(produto);
    }
    public void deletarProduto(Produto prd){
        produtoRepository.delete(prd); 
    }
}
