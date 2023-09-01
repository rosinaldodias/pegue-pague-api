package com.pegue.pague.api.service;

import java.util.List;
import java.util.Optional;

import com.pegue.pague.api.controller.dto.ClienteDto;
import com.pegue.pague.api.entity.Cliente;
import com.pegue.pague.api.entity.Pessoa;

public interface ClienteService {
	
	Cliente save(ClienteDto dto);
    Optional<ClienteDto> findByIdCliente(Long codigo);
	List<ClienteDto> findByAllCliente();
	Pessoa editar(Pessoa pes, Long codigo);
	

}
