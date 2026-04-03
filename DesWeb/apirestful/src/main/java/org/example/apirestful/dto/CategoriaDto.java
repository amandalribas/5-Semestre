package org.example.apirestful.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CategoriaDto(Long id,
                           String nome,
                           @JsonProperty("produtos")
                           List<ProdutoDto> produtosDto) {


}
