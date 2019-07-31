package com.github.douglsantos.dataprovider.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.douglsantos.domain.Pedido;
import com.github.douglsantos.http.constants.HeaderConstants;
import com.github.douglsantos.usecase.gateway.RestGateway;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class RestDataProvider implements RestGateway {

	private RestTemplate defaultRestTeamplate;

	@Value("${lojafeliz.url.api}")
	private String url;
	
	@Autowired
	public RestDataProvider(@Qualifier("defaultRestTeamplate") RestTemplate defaultRestTeamplate) {
		this.defaultRestTeamplate = defaultRestTeamplate;
	}
	
	@Override
	public List<Pedido> listarTodos(int quantidadePedidos) {
		StopWatch stopWatch = new StopWatch();

		final URI uri = UriComponentsBuilder
				.fromHttpUrl(url)
				.queryParam("quantidadePedidos", quantidadePedidos)
				.build()
				.encode()
				.toUri();
		
		final RequestEntity<Void> requestEntity = RequestEntity
					.get(uri)
					.header(HttpHeaders.CONTENT_TYPE, HeaderConstants.CONTENT_TYPE_JSON)
					.build();
		
		stopWatch.start("consumindo api com json");
		
		final ResponseEntity<List<Pedido>> responseEntity = 
				defaultRestTeamplate.exchange(requestEntity, new ParameterizedTypeReference<List<Pedido>>() {
				});

		stopWatch.stop();


		log.info("Total em milisegundos GET API [JSon]: {}ms and size: {}",
				stopWatch.getLastTaskTimeMillis(),
				responseEntity.getHeaders().getContentLength());
		
		return responseEntity.getBody();
	}

}
