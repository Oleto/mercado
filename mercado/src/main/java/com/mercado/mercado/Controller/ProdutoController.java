package com.mercado.mercado.Controller;

import com.mercado.mercado.Entities.Produto;
import com.mercado.mercado.Service.ProdutoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        try{
            produtoService.criarOuAtualizar(produto);}
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
    public ResponseEntity<Produto> BuscarPorId(@PathVariable int id) {
        try {
            Optional<Produto> produto = produtoService.obterPorId(id);
            if (produto.isPresent()) {
                return ResponseEntity.ok(produto.get());
            }else {
                return ResponseEntity.notFound().build();
            }
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
    public ResponseEntity<String> DeletebyId(@PathVariable int id) {
        if (!produtoService.obterPorId(id).isPresent()) {
            return ResponseEntity.status(404).body("Produto não encontrado para exclusão!");
        }
        produtoService.deletar(id);
        return ResponseEntity.ok("Produto deletado com sucesso!");

    }
    @GetMapping("/{tipo}")
    public ResponseEntity<Produto> BuscarPorTipo(@PathVariable String tipo) {
        try {
            List<Produto> produtos = produtoService.obterPorTipo(tipo);
            if (!produtos.isEmpty()) {
                return ResponseEntity.ok(produtos.get(-produtos.size() - 1));
            }

        }catch (Exception e){
            log.error("e: ", e);
        }return null;
    }
    @PutMapping("/alterar")
    public ResponseEntity<String> Alterar(@RequestBody Produto produto) {
        if (!produtoService.obterPorId(produto.getId()).isPresent()) {
            return ResponseEntity.status(404).body("Produto não encontrado para exclusão!");
        }
        produtoService.deletar(produto.getId());
        return ResponseEntity.ok("Produto deletado com sucesso!");
    }
    }




