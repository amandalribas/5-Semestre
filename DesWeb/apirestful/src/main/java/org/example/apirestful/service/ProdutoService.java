package org.example.apirestful.service;

import jakarta.transaction.Transactional;
import org.example.apirestful.dto.ProdutoCreate;
import org.example.apirestful.dto.ProdutoDto;
import org.example.apirestful.exception.EntidadeNaoEncontradaException;
import org.example.apirestful.mapper.ProdutoMapper;
import org.example.apirestful.model.Produto;
import org.example.apirestful.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Componenete do tipo serviço: Trata as Regras de Negócio.
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    @Autowired
    private ProdutoMapper produtoMapper;

    public List<ProdutoDto> recuperarProdutos() {
        //vai no bd e recupera um list de produtos
        List<Produto> produtos = produtoRepository.recuperarProdutos();
        //precisa converter em List<ProdutoDto>
        return produtoMapper.toProdutosDto(produtos);
    }

    public ProdutoDto recuperarProdutoPorId(long id) {
        Produto produto = produtoRepository.findById(id) //trás o objeto e suas categorias
                .orElseThrow( () -> new EntidadeNaoEncontradaException(
                        "Produto com id = " + id + "não encontrado. "));
        return produtoMapper.toProdutoDto(produto);
    }

    public ProdutoDto cadastrarProduto(ProdutoCreate produtoCreate){
        Produto produto = produtoMapper.toProduto(produtoCreate);  //id Será Nulo
        produto = produtoRepository.save(produto); //chama o persist do JPA
        return produtoMapper.toProdutoDto(produto);
    }

    public ProdutoDto alterarProduto(ProdutoDto produtoDto){
        Produto produto = produtoMapper.toProduto(produtoDto);
        produto = produtoRepository.save(produto); //merge do JPA
        return produtoMapper.toProdutoDto(produto);
    }

    public void removerProdutoPorId(long id){
        recuperarProdutoPorId(id);
        produtoRepository.deleteById(id);
    }
}
