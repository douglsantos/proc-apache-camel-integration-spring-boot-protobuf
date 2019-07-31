package com.github.douglsantos.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
	
	private String pedidoId;
	private Cliente cliente;
	private List<Produto> produtos;

}
