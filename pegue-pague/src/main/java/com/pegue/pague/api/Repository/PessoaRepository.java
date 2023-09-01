package com.pegue.pague.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.pegue.pague.api.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	@Transactional(readOnly = true)
	Pessoa findByEmail(String email);

}
