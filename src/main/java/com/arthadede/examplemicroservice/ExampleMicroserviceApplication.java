package com.arthadede.examplemicroservice;

import com.arthadede.examplemicroservice.model.Todo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ExampleMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExampleMicroserviceApplication.class, args);
	}
}
