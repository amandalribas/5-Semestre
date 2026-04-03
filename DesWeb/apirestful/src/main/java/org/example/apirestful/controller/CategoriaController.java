package org.example.apirestful.controller;


import org.example.apirestful.dto.CategoriaDto;
import org.example.apirestful.mapper.CategoriaMapper;
import org.example.apirestful.model.Categoria;
import org.example.apirestful.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("categorias")
@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @Autowired
    private CategoriaMapper categoriaMapper;

    @GetMapping("v1")
    public List<Categoria> recuperarCategoriasComProdutosV1(){
        List<Categoria> categorias =  categoriaService.recuperarCategoriasComProdutosV1();
        categorias.forEach((categoria) -> {
            System.out.println("Categoria: " + categoria.getNome());
            categoria.getProdutos().forEach((produto) -> {
                System.out.println("   Produto: " + produto.getNome());
            });
        });
        return categorias;
    }

    @GetMapping("v2")
    public List<CategoriaDto> recuperarCategoriasComProdutosV2(){
        //List<Categoria> categorias =  categoriaService.recuperarCategoriasComProdutosV2();
        //return categoriaMapper.toCategoriasDto(categorias);
        return categoriaService.recuperarCategoriasComProdutosV2();
    }

}
