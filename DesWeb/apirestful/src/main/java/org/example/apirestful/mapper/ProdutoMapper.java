package org.example.apirestful.mapper;


import org.example.apirestful.dto.CategoriaResumo;
import org.example.apirestful.dto.ProdutoCreate;
import org.example.apirestful.dto.ProdutoDto;
import org.example.apirestful.model.Categoria;
import org.example.apirestful.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    List<ProdutoDto> toProdutosDto(List<Produto> produtos);


    @Mapping(source = "categoria", target = "categoriaResumo")//fonte Produto, na fonte o nome do campo é categoria. Converto categoria em categoriaResumo
    ProdutoDto toProdutoDto(Produto produto);
    //se os campos fossem identicos entre Produto e ProdutoDto não precisaria criar o método
    //para fazer o Save precisa ProdutoDto ->Produto

    @Mapping(source = "categoriaResumo", target = "categoria")
    Produto toProduto(ProdutoCreate produtoCreate);

    @Mapping(source = "categoriaResumo", target = "categoria")
    Produto toProduto(ProdutoDto produtoDto);
}
