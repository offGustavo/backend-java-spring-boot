package com.turboorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.turboorder.model.Contato;
import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
  // Adicionando o método findTop10ByConTelefoneContaining
  List<Contato> findTop10ByConTelefoneContaining(String telefone);
}
