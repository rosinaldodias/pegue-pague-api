package com.pegue.pague.api.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pegue.pague.api.Repository.PessoaRepository;
import com.pegue.pague.api.entity.Pessoa;
import com.pegue.pague.api.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRepository repo;
	
	@Override
	public Pessoa save(Pessoa pessoa) {
		return repo.save(pessoa);
	
	}

}
