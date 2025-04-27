package com.turboorder.controller;

import com.turboorder.model.Produto;
import com.turboorder.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos") // Mapeia todas as rotas com /produtos
public class ProdutoController {

  private final ProdutoService produtoService;

  public ProdutoController(ProdutoService produtoService) {
    this.produtoService = produtoService;
  }

  // GET /produtos - Listar todos os produtos
  @GetMapping
  public List<Produto> listarTodos() {
    return produtoService.listarTodos();
  }

  // GET /produtos/{id} - Buscar um produto por ID
  @GetMapping("/{id}")
  public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id) {
    return produtoService.buscarPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  // POST /produtos - Criar um novo produto
  @PostMapping
  public Produto criarProduto(@RequestBody Produto produto) {
    return produtoService.salvar(produto);
  }

  // PUT /produtos/{id} - Atualizar um produto existente
  @PutMapping("/{id}")
  public ResponseEntity<Produto> atualizarProduto(@PathVariable Integer id, @RequestBody Produto produtoAtualizado) {
    return produtoService.buscarPorId(id)
        .map(produtoExistente -> {
          // Atualiza os campos do produto
          produtoExistente.setNome(produtoAtualizado.getNome());
          produtoExistente.setTipo(produtoAtualizado.getTipo());
          produtoExistente.setAtivo(produtoAtualizado.getAtivo());
          Produto atualizado = produtoService.salvar(produtoExistente);
          return ResponseEntity.ok(atualizado);
        })
        .orElse(ResponseEntity.notFound().build());
  }

  // DELETE /produtos/{id} - Deletar um produto
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarProduto(@PathVariable Integer id) {
    if (produtoService.buscarPorId(id).isPresent()) {
      produtoService.deletar(id);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
