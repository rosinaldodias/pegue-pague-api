package com.pegue.pague.api.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pegue.pague.api.Repository.CategoriaRepository;
import com.pegue.pague.api.entity.Categoria;
import com.pegue.pague.api.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
		
	@Override
	public List<Categoria> findByAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Categoria> findById(Long codigo) {
		// TODO Auto-generated method stub
		return repo.findById(codigo);
	}

	@Override
	public Categoria save(Categoria categoria) {
		return  repo.save(categoria);
		
	}

	@Override
	public void delete(Long codigo) {
		repo.deleteById(codigo);
	}

	@Override
	@Transactional
	public Categoria edit(Long codigo ,Categoria categoria) {
		Categoria categoriaSalva = buscaPorId(codigo);
		BeanUtils.copyProperties(categoria, categoriaSalva, "id");
		return this.repo.save(categoriaSalva);
		
	}


	@Override
	public void atualizaPropriedadeAtivo(Long codigo, Boolean ativo) {
		Categoria categoriaSalva =  buscaPorId(codigo);
		categoriaSalva.setAtivo(ativo);
		repo.save(categoriaSalva);
	}
	
	@Transactional(readOnly = true)
	private Categoria buscaPorId(Long codigo) {
		Categoria categoriaSalva = repo.findById(codigo)
				.orElseThrow( () -> new EmptyResultDataAccessException(1));
		return categoriaSalva;
	}

}
