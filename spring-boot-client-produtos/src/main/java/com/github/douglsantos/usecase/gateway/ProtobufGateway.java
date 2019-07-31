package com.github.douglsantos.usecase.gateway;

import com.github.douglsantos.domain.proto.PedidosProto.Pedidos;

public interface ProtobufGateway {
	public Pedidos listarTodos(int quantidadePedidos);
}
