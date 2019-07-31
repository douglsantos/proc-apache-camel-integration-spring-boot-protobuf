package com.github.douglsantos.domain;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pedido {
	private String pedidoId;
	private Cliente cliente;
	private List<Produto> produtos;

}
