package com.pegue.pague.api.service;

import java.util.List;
import java.util.Optional;

import com.pegue.pague.api.entity.Categoria;

public interface CategoriaService {

	List<Categoria> findByAll();
	Optional<Categoria> findById(Long codigo);
	Categoria save(Categoria categoria);
	void delete (Long codigo);
	Categoria edit(Long codigo, Categoria categoria);
	void atualizaPropriedadeAtivo(Long codigo, Boolean ativo);
}
