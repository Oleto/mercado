package com.mercado.mercado.Controller;

import com.mercado.mercado.Entities.Produto;
import com.mercado.mercado.Service.ProdutoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private static final Logger log = LogManager.getLogger(ProdutoController.class);
    @Autowired
  private  ProdutoService produtoService;


    @PostMapping("/")
    public void salvar(@RequestBody Produto produto) {
        try{produtoService.criarOuAtualizar(produto);}
        catch(Exception e){
            log.error("e: ", e);
        }

    }
    @GetMapping("/")
    public Iterable<Produto> listar(){
        try {
            return produtoService.listarTodos();
        }catch (Exception e){
            log.error("e: ", e);
        }return null;
    }
    @GetMapping("/{id}")
    public Optional<Produto> BuscarPorId(@PathVariable int id) {
        try {
            return produtoService.obterPorId(id);
        }catch (Exception e){
            log.error("e: ", e);
        }return null;
    }
    @GetMapping("/{nome}")
    public List<Produto> BuscarPorNome(@PathVariable String nome) {
        try {
            return produtoService.obterPornome(nome);
        }catch (Exception e){
            log.error("e: ", e);
        }return null;
    }
    @DeleteMapping("/{id}")
    public void DeletebyId(@PathVariable int id) {
        try {
            produtoService.deletar(id);
        }catch (Exception e){
            log.error("e: ", e);
        }

    }
    @GetMapping("/{tipo}")
    public List<Produto> BuscarPorTipo(@PathVariable String tipo) {
        try {
            return produtoService.obterPorTipo(tipo);
        }catch (Exception e){
            log.error("e: ", e);
        }return null;
    }
    @GetMapping("/alterar")
    public Produto Alterar(@RequestBody Produto produto) {
       try {
           return produtoService.criarOuAtualizar(produto);
       }catch (Exception e){
           log.error("e: ", e);
       }return null;
    }
    @GetMapping("/alterar-estoque")
    public Produto AlterarEstoque(@RequestBody Produto produto) {
        try {
            return produtoService.criarOuAtualizar(produto);
        }catch (Exception e){
            log.error("e: ", e);
        }return null;
    }


}
