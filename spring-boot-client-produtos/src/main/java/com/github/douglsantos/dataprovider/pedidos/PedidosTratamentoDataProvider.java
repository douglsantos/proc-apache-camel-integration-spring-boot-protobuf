package com.github.douglsantos.dataprovider.pedidos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.douglsantos.domain.Cliente;
import com.github.douglsantos.domain.Pedido;
import com.github.douglsantos.domain.Produto;
import com.github.douglsantos.http.constants.HeaderConstants;
import com.github.douglsantos.usecase.gateway.ProtobufGateway;
import com.github.douglsantos.usecase.gateway.RestGateway;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class PedidosTratamentoDataProvider {

	private RestGateway restGateway;
	private ProtobufGateway protobufGateway;

	@Autowired
	public PedidosTratamentoDataProvider(RestGateway restGateway, ProtobufGateway protobufGateway) {
		this.restGateway = restGateway;
		this.protobufGateway = protobufGateway;
	}

	public List<Pedido> listarTodos(int quantidadePedidos, String contentType) {

		try {
			if (contentType.contentEquals(HeaderConstants.CONTENT_TYPE_PROTOBUF)) {
				return protobufListarTodos(quantidadePedidos);
			}

			if (contentType.contentEquals(HeaderConstants.CONTENT_TYPE_JSON)) {
				return restListarTodos(quantidadePedidos);
			}
		} catch (Exception ex) {
			log.catching(ex);
		}
		return null;

	}

	/*
	 * Metodo que chama DataProvider com response em JSon
	 */
	private List<Pedido> restListarTodos(int quantidadePedidos) {
		return restGateway.listarTodos(quantidadePedidos);
	}

	/*
	 * Metodo que chama DataProvider com response em Protobuf
	 */
	private List<Pedido> protobufListarTodos(int quantidadePedidos) {
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		List<Produto> produtos = new ArrayList<Produto>();
		
		List<com.github.douglsantos.domain.proto.PedidosProto.Pedido> pedidosProtobuf = protobufGateway.listarTodos(quantidadePedidos).getPedidosList();
		
		for(com.github.douglsantos.domain.proto.PedidosProto.Pedido pedidoProtobuf : pedidosProtobuf) {
			
			Cliente cliente = Cliente.builder()
					.clienteId(pedidoProtobuf.getCliente().getClienteId())
					.nome(pedidoProtobuf.getCliente().getNome())
					.build();
			
			Produto produto = null;
			
			for(com.github.douglsantos.domain.proto.PedidosProto.Produto produtoProtobuf : pedidoProtobuf.getProdutoList()) {
				produto = Produto.builder()
						.produtoId(produtoProtobuf.getProdutoId())
						.descricaoProduto(produtoProtobuf.getDescricao())
						.parceiro(produtoProtobuf.getParceiro())
						.valorUnitario(produtoProtobuf.getValorUnitario())
						.build();
				produtos.add(produto);
			}
			
			Pedido pedido = Pedido.builder()
					.pedidoId(pedidoProtobuf.getPedidoId())
					.produtos(produtos)
					.cliente(cliente)
					.build();
			
			pedidos.add(pedido);
		}
		
		return pedidos;
	}

}
