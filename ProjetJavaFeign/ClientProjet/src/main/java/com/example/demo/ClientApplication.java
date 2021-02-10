package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients("com.example.demo")
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ClientRepository clientRepository){
        return args -> {
            clientRepository.save(new Client((long) 1, "Samir", "Youcef@mail"));
            clientRepository.save(new Client((long) 2, "Bertrand", "Russel@mail"));
            clientRepository.save(new Client((long) 3, "Alan", "Turing@mail"));
            clientRepository.save(new Client((long) 4, "Bernard", "Riemann@mail"));

        };
    }
}