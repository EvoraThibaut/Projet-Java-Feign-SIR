package com.example.demo;
import com.example.demo.CommandeBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "microservice-commandes", url = "localhost:9002")
public interface MicroserviceCommandeProxy {
    @PostMapping(value = "/commandes")
    public ResponseEntity<CommandeBean> ajouterCommande(@RequestBody CommandeBean commande);

    @GetMapping(value = "/commandes/{id}")
    public CommandeBean recupererUneCommande(@PathVariable Long id);
}
