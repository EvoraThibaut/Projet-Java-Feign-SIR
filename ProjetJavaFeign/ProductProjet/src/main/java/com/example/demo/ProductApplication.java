package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.demo")
@EnableFeignClients("com.example.demo")
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product(1, "Tablette", 1200, 86));
			productRepository.save(new Product(2, "Ordi", 1500, 2));
			productRepository.save(new Product(3, "PlayStation3", 400, 1));
			productRepository.findAll().forEach(product -> {
				System.out.println(product.toString()); });

		};
	}
}