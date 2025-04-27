package com.turboorder.repository;

import com.turboorder.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
  // Aqui você pode adicionar métodos personalizados depois se quiser
}
