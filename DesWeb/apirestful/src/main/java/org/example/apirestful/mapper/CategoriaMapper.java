package org.example.apirestful.mapper;

import org.example.apirestful.dto.CategoriaDto;
import org.example.apirestful.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProdutoMapper.class)
public interface CategoriaMapper {

    List<CategoriaDto> toCategoriasDto(List<Categoria> categorias);

    @Mapping(source = "produtos", target = "produtosDto")
    CategoriaDto toCategoriaDto(Categoria categoria);
}
