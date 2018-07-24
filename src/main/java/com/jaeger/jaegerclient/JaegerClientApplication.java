package com.jaeger.jaegerclient;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JaegerClientApplication {

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
