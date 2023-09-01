package com.pegue.pague.api.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pegue.pague.api.entity.Produto;

public interface ProdutoRepository  extends JpaRepository<Produto, Long> {

	List<Produto> findByNomeContains(String nome); 
}
