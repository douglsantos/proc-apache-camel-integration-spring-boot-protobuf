package com.github.douglsantos.process.proto;

import java.util.UUID;
import java.util.stream.IntStream;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.github.douglsantos.domain.proto.PedidosProto;
import com.github.douglsantos.domain.proto.PedidosProto.Pedidos;
import com.github.douglsantos.domain.proto.PedidosProto.Produto;
import com.github.douglsantos.util.constant.ProdutoConstants;

public class MockProtoProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		int contentLength = exchange.getIn().getHeader("quantidadePedidos", Integer.class);
		exchange.getIn().setHeader("Content-Type", "application/x-protobuf");
		exchange.getIn().setBody(pedidosProtobuf(contentLength));
	}

	private PedidosProto.Pedidos pedidosProtobuf(int contentLength) {
		final Pedidos.Builder pedidos = Pedidos.newBuilder();

		IntStream.range(0, contentLength).forEach(iteration -> {

			final PedidosProto.Cliente cliente = 
					PedidosProto.Cliente.newBuilder()
						.setClienteId(UUID.randomUUID().toString())
						.setNome(ProdutoConstants.NOME_CLIENTE)
					.build();
			
			final Produto produtoUm = 
					Produto.newBuilder()
						.setProdutoId(UUID.randomUUID().toString())
						.setDescricao("PlayStation 4")
						.setParceiro("Sony")
						.setValorUnitario(3500)
					.build();
			
			final Produto produtoDois = 
					Produto.newBuilder()
						.setProdutoId(UUID.randomUUID().toString())
						.setDescricao("Xbox One X")
						.setParceiro("Micro$oft")
						.setValorUnitario(10000)
					.build();

			final Produto produtoTres = 
					Produto.newBuilder()
						.setProdutoId(UUID.randomUUID().toString())
						.setDescricao("Galaxy Fold")
						.setParceiro("Samsung")
						.setValorUnitario(50000)
					.build();


			final PedidosProto.Pedido pedido = 
					PedidosProto.Pedido.newBuilder()
						.setPedidoId(UUID.randomUUID().toString())
						.setCliente(cliente)
						.addProduto(produtoUm)
						.addProduto(produtoDois)
						.addProduto(produtoTres)
					.build();

			pedidos.addPedidos(pedido);
		});

		return pedidos.build();
	}

}
