package com.pegue.pague.api.service;

import java.util.Date;

import com.pegue.pague.api.controller.dto.PedidoDto;
import com.pegue.pague.api.entity.Pedido;

public interface PedidoService {
	Pedido salvar(PedidoDto dto);
	PedidoDto findById(Long id);
	PedidoDto findBydata(Date data1, Date data2);
	
	

}
