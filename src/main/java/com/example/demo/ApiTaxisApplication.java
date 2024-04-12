package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// La anotación @SpringBootApplication combina @Configuration, @EnableAutoConfiguration y @ComponentScan
// Indica que esta clase es la clase principal de la aplicación Spring Boot
@SpringBootApplication
// Método principal que inicia la aplicación Spring Boot
public class ApiTaxisApplication {
	// Ejecuta la aplicación Spring Boot, pasando la clase ApiTaxisApplication y los argumentos de línea de comandos
	public static void main(String[] args) {
		SpringApplication.run(ApiTaxisApplication.class, args);
	}


}