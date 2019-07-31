package com.github.douglsantos.process.json;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.github.douglsantos.domain.Cliente;
import com.github.douglsantos.domain.Pedido;
import com.github.douglsantos.domain.Produto;
import com.github.douglsantos.util.constant.ProdutoConstants;

public class MockJsonProcessor implements Processor {
	
	@Override
	public void process(Exchange exchange) throws Exception {
		int contentLength = exchange.getIn().getHeader("quantidadePedidos", Integer.class);
		exchange.getIn().setHeader("Content-Type", "application/json");
		exchange.getIn().setBody(pedidosJson(contentLength));
	}

	private List<Pedido> pedidosJson(int contentLength) {
		final List<Pedido> pedidos = new ArrayList<Pedido>(20);
		final List<Produto> produtos = new ArrayList<Produto>();

		IntStream.range(0, contentLength).forEach(iteraction -> {
			final Cliente cliente = 
					Cliente.builder()
						.clienteId(UUID.randomUUID().toString())
						.nome(ProdutoConstants.NOME_CLIENTE)
					.build();

			final Produto produtoUm = 
					Produto.builder()
						.produtoId(UUID.randomUUID().toString())
						.descricaoProduto("PlayStation 4")
						.parceiro("Sony")
						.valorUnitario(3500)
					.build();
			
			final Produto produtoDois = 
					Produto.builder()
						.produtoId(UUID.randomUUID().toString())
						.descricaoProduto("Xbox One X")
						.parceiro("Micro$oft")
						.valorUnitario(10000)
					.build();
			
			final Produto produtoTres = 
					Produto.builder()
						.produtoId(UUID.randomUUID().toString())
						.descricaoProduto("Galaxy Fold")
						.parceiro("Samsung")
						.valorUnitario(50000)
					.build();
			
			produtos.add(produtoUm);
			produtos.add(produtoDois);
			produtos.add(produtoTres);
			
			final Pedido pedido = 
					Pedido.builder()
						.pedidoId(UUID.randomUUID().toString())
						.cliente(cliente)
						.produtos(produtos)
					.build();

			pedidos.add(pedido);
		});

		return pedidos;
	}
}
