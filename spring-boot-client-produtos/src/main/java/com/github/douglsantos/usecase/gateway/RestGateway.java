package com.github.douglsantos.usecase.gateway;

import java.util.List;

import com.github.douglsantos.domain.Pedido;

public interface RestGateway {
	public List<Pedido> listarTodos(int quantidadePedidos);
}
