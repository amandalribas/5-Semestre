package org.example.apirestful.service;

import org.example.apirestful.dto.CategoriaDto;
import org.example.apirestful.mapper.CategoriaMapper;
import org.example.apirestful.model.Categoria;
import org.example.apirestful.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;


    public List<Categoria> recuperarCategoriasComProdutosV1(){
        return categoriaRepository.recuperarCategoriasComProdutos();
    }

    public List<CategoriaDto> recuperarCategoriasComProdutosV2(){
        List<Categoria> categorias = categoriaRepository.recuperarCategoriasComProdutos();
        return categoriaMapper.toCategoriasDto(categorias);
    }

}
