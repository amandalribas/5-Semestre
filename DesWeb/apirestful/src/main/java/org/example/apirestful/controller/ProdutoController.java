package org.example.apirestful.controller;

import jakarta.validation.Valid;
import org.example.apirestful.dto.ProdutoCreate;
import org.example.apirestful.dto.ProdutoDto;
import org.example.apirestful.exception.EntidadeNaoEncontradaException;
import org.example.apirestful.mapper.ProdutoMapper;
import org.example.apirestful.model.Produto;
import org.example.apirestful.repository.ProdutoRepository;
import org.example.apirestful.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController //toda vez que chegar uma requisição para /produtos o tomcat recebe e procura um controller de uma aplicação restful
@RequestMapping("produtos") //Se chegar uma requisição para /produtos esse controler vai aceitar requisições
//ao encontrar requisições (do tipo get, put, delete, post):
public class ProdutoController {

    //private ProdutoService produtoService = new ProdutoService();
    @Autowired //injeta em produtoService um objeto de uma classe que extende PRodutoService
    private ProdutoService produtoService;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoMapper produtoMapper;



    //se chegar uma requisição do tipo get, esse método será executado
    //Ex: Digitar url e enter : https//localhost8080/produtos
    //Controler chama serviço, serviço chama repositório
    @GetMapping public List<ProdutoDto> recuperarProdutos(){
        return produtoService.recuperarProdutos();
    }

    //https//localhost8080/produtos/id
    @GetMapping("{idProduto}")
    public ProdutoDto recuperarProdutoPorId(@PathVariable("idProduto") long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
                "Produto com id = " + id + "não encontrado"
                ));
        return produtoMapper.toProdutoDto(produto);
    }
        //return produtoService.recuperarProdutoPorId(id); //Pega o objeto, cria um response entity, cria um produto com status ok e retorna
        //retorna um produto para o spring boot, que cria um objeto do tipo ResponseEntity, coloca o Produto dentro e o status ok e envia pro Browser

//    @GetMapping("{idProduto}")
//    public ResponseEntity<?> recuperarProdutoPorId(@PathVariable("idProduto") long id){
//        try{
//            Produto produto = produtoService.recuperarProdutoPorId(id);
//            return new ResponseEntity(produto, HttpStatus.OK);
//        }catch (EntidadeNaoEncontradaException e){
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }


    @PostMapping
    public ProdutoDto cadastrarProdutos(@RequestBody @Valid ProdutoCreate produtoCreate){
        return produtoService.cadastrarProduto(produtoCreate);
    }


    @PutMapping
    public ProdutoDto alterarProdutos(@RequestBody ProdutoDto produtoDto){
        return produtoService.alterarProduto(produtoDto);
    }


    @DeleteMapping("{idProduto}")
    public void removerProdutoPorId(@PathVariable("idProduto") long id){
        produtoService.removerProdutoPorId(id);

    }
}
