package com.jaeger.jaegerclient;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class JaegerClientApplication {
	
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
		return restTemplateBuilder.build();
	}

	@Bean
	public Tracer jaegerTracer(){
		Configuration configuration = new Configuration("spring-boot");
		Tracer tracer = configuration.getTracerBuilder().build();
		return tracer;
	}

	public static void main(String[] args) {
		SpringApplication.run(JaegerClientApplication.class, args);
	}
}
