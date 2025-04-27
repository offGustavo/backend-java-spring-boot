package com.turboorder.repository;

import com.turboorder.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
  Optional<Cliente> findByContato_ConTelefoneAndCliAtivoTrue(String telefone);

  List<Cliente> findAllByCliAtivoTrue();
}
