package com.pegue.pague.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pegue.pague.api.entity.Pedido;

public interface PedidoRepository  extends JpaRepository<Pedido, Long> {

}
