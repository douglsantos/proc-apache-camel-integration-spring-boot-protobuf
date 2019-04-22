package com.github.douglsantos.route.rest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

@Component
public class RouteRestConfig extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		restConfiguration()
			.component("restlet")
			.contextPath("/lojafeliz/v1")
			.host("localhost")
			.port("8081")
			.enableCORS(true)
			.bindingMode(RestBindingMode.json);
		
		rest()
			.get("/produtos")
				.param()
					.name("quantidadePedidos")
					.dataType("string")
					.type(RestParamType.query)
					.required(true)
				.endParam()
			.to("direct:get-route-produtos");
	}

}
