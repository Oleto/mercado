package com.mercado.mercado.Service;

import com.mercado.mercado.Entities.Produto;
import com.mercado.mercado.Repository.RepositoryProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private RepositoryProduto produtoRepository;



    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> obterPorId(Integer id) {
        return produtoRepository.findById(id);
    }
    public List<Produto> obterPornome(String nome) {
        return produtoRepository.findProdutoByNome(nome);
    }
    public List<Produto> obterPorTipo(String tipo) {
        return produtoRepository.findProdutoByTipo(tipo);
    }

    public Produto criarOuAtualizar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletar(Integer id) {
        produtoRepository.deleteById(id);
    }

}
