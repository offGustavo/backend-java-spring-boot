package com.turboorder.service;

import com.turboorder.model.Produto;
import com.turboorder.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

  private final ProdutoRepository produtoRepository;

  public ProdutoService(ProdutoRepository produtoRepository) {
    this.produtoRepository = produtoRepository;
  }

  public List<Produto> listarTodos() {
    return produtoRepository.findAll();
  }

  public Optional<Produto> buscarPorId(Integer id) {
    return produtoRepository.findById(id);
  }

  public Produto salvar(Produto produto) {
    return produtoRepository.save(produto);
  }

  public void deletar(Integer id) {
    produtoRepository.deleteById(id);
  }
}
