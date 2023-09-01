package com.pegue.pague.api.controller.dto;

import java.util.List;

public class PedidoDto {
	private String cliente;
	private String vendedor;
	private String tipoPedido;
	private List<ItensPedidoDto> items;

}
