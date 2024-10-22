package com.mercado.mercado.Repository;

import com.mercado.mercado.Entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryProduto extends JpaRepository<Produto, Integer> {
    List<Produto> findProdutoByNome(String nome);
    Produto findProdutoById(Integer id);
    List<Produto>findProdutoByTipo(String tipo);



}
