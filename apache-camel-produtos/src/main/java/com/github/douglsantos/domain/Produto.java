package com.github.douglsantos.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Produto {
	
	private String produtoId;
	private String descricaoProduto;
	private String parceiro;
	private Integer valorUnitario;
}
