package com.jaeger.jaegerclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/")
	public String index() {
		return "Index servicio uno";
	}
	
    @SuppressWarnings("unused")
	@RequestMapping("/hello")
    public String hello() throws Exception{
    	if(true) {
			throw new Exception();
    	}
        return "Hola desde Controller";
    }

    @RequestMapping("/chaining")
    public String chaining() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8081/dos", String.class);
        return "Chaining + " + response.getBody();
    }


}
