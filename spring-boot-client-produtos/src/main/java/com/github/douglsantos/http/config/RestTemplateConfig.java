package com.github.douglsantos.http.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class RestTemplateConfig {

	private final ProtobufHttpMessageConverter converter;
	
	@Bean
	public RestTemplate protobufRestTemplate() {
			return new RestTemplate(Collections.singletonList(converter));
	}

	@Bean
	public RestTemplate defaultRestTeamplate() {
		return new RestTemplate();
	}
}
