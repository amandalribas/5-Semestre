package org.example.apirestful.repository;

import org.example.apirestful.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


//vamos conseguir cadastrar produtos, recuperar...
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    //Left Join: trás os produtos tendo ou não categoria
    //fetch: os objetos são inicializados na lista, ao invés de haver um proxy
    @Query("select p from Produto p left join fetch p.categoria order by p.id")//código JPQL -> Não é SQL, mas é transformado
    List<Produto> recuperarProdutos();

}
