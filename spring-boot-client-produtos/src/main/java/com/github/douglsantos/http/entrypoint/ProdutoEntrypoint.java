package com.github.douglsantos.http.entrypoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.douglsantos.domain.Pedido;
import com.github.douglsantos.usecase.PedidoUseCase;

@RestController
public class ProdutoEntrypoint {
	
	private PedidoUseCase pedidoUseCase;

	@Autowired
	public ProdutoEntrypoint(PedidoUseCase pedidoUseCase) {
		this.pedidoUseCase = pedidoUseCase;
	}



	@GetMapping("/produtos")
	public ResponseEntity<?> listarPedidos(
			@RequestHeader(HttpHeaders.CONTENT_TYPE) String contentType,
			@RequestParam int quantidadePedidos) {
		
		return new ResponseEntity<List<Pedido>>(pedidoUseCase.listarTodos(quantidadePedidos, contentType), HttpStatus.OK);
	}
}
