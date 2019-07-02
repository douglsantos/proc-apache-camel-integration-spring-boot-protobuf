package com.github.douglsantos.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
	
	private String produtoId;
	private String descricaoProduto;
	private String parceiro;
	private Integer valorUnitario;
}
