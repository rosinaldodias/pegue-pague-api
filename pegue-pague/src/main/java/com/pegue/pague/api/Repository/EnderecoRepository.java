package com.pegue.pague.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pegue.pague.api.entity.Endereco;

public interface EnderecoRepository  extends JpaRepository<Endereco, Long> {

}
