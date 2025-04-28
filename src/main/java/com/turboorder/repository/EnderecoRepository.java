
package com.turboorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.turboorder.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
