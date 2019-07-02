package com.github.douglsantos.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.douglsantos.dataprovider.pedidos.PedidosTratamentoDataProvider;
import com.github.douglsantos.domain.Pedido;

@Service
public class PedidoUseCase {
	
	private PedidosTratamentoDataProvider pedidosDataProvider;
	
	@Autowired	
	public PedidoUseCase(PedidosTratamentoDataProvider pedidosDataProvider) {
		this.pedidosDataProvider = pedidosDataProvider;
	}

	public List<Pedido> listarTodos(int quantidadePedidos, String contentType) {
		return pedidosDataProvider.listarTodos(quantidadePedidos, contentType);
	}
	
	
}
