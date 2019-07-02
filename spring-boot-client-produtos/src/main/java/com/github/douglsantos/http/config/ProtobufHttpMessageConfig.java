package com.github.douglsantos.http.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

@Configuration
public class ProtobufHttpMessageConfig {

	@Bean
	public ProtobufHttpMessageConverter converter() {
		return new ProtobufHttpMessageConverter();
	}
}
