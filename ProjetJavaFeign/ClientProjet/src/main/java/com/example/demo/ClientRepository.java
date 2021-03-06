package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// On utilise Spring rest data
@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {
}
