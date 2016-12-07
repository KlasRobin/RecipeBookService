package com.recepieBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("entities")
@ComponentScan("repositories")
@EnableJpaRepositories("repositories")
@SpringBootApplication
public class RecipeBookRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeBookRestServiceApplication.class, args);
	}
}
