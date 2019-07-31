package com.github.douglsantos.dataprovider.protobuf;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.douglsantos.domain.proto.PedidosProto.Pedidos;
import com.github.douglsantos.usecase.gateway.ProtobufGateway;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ProtobufDataProvider implements ProtobufGateway {

	private RestTemplate protobufRestTemplate;
	
	@Value("${lojafeliz.url.api}")
	private String url;
	
	
	@Autowired
	public ProtobufDataProvider(@Qualifier("protobufRestTemplate") RestTemplate protobufRestTemplate) {
		this.protobufRestTemplate = protobufRestTemplate;
	}


	@Override
	public Pedidos listarTodos(int quantidadePedidos) {
		StopWatch stopWatch = new StopWatch();
		
		final URI uri = UriComponentsBuilder
				.fromHttpUrl(url)
				.queryParam("quantidadePedidos", quantidadePedidos)
				.build()
				.encode()
				.toUri();
		
		final RequestEntity<Void> requestEntity = RequestEntity
				.get(uri)
				.header(HttpHeaders.CONTENT_TYPE, "application/x-protobuf")
				.build();
		
		stopWatch.start("consumindo api com protobuf");
		
		final ResponseEntity<Pedidos> responseEntity = 
					protobufRestTemplate.exchange(requestEntity, Pedidos.class);
		
		stopWatch.stop();

		log.info("Total em milisegundos GET API [Protobuf]: {}ms and size: {}",
				stopWatch.getLastTaskTimeMillis(),
				responseEntity.getHeaders().getContentLength());
		
		return responseEntity.getBody();
		
		
	}

}
