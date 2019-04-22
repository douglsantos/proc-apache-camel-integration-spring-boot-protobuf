package com.github.douglsantos.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.github.douglsantos.process.json.MockJsonProcessor;
import com.github.douglsantos.process.proto.MockProtoProcessor;


@Component
public class ProdutoRoute extends RouteBuilder {
	
	@Override
	public void configure() throws Exception {
		
		from("direct:get-route-produtos")
			.choice()
				.when(header("Content-Type").isEqualTo("application/x-protobuf"))
					.process(new MockProtoProcessor())
					.marshal().protobuf()
//					.marshal().gzip()
					.log("${body}")
				.when(header("Content-Type").isEqualTo("application/json"))
					.process(new MockJsonProcessor())
//					.marshal().json(JsonLibrary.Jackson)
//					.marshal().gzip()
					.log("${body}")
				.otherwise()
					.log("${body}")
			.endChoice()
		.end();
	}
}
