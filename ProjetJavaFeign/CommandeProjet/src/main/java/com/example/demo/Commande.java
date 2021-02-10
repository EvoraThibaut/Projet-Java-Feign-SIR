package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Commande {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer productId;

    private Date dateCommande;

    private Integer quantite;

    private Boolean commandePayee;

    public Commande() {
    }

    public Commande(Long id, Integer productId, Date dateCommande, Integer quantite, Boolean commandePayee) {
        this.id = id;
        this.productId = productId;
        this.dateCommande = dateCommande;
        this.quantite = quantite;
        this.commandePayee = commandePayee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Boolean getCommandePayee() {
        return commandePayee;
    }

    public void setCommandePayee(Boolean commandePayee) {
        this.commandePayee = commandePayee;
    }

    @Override
    public String toString() {
        return "commande{" +
                "id=" + id +
                ", productId=" + productId +
                ", dateCommande=" + dateCommande +
                ", quantite=" + quantite +
                ", commandePayee=" + commandePayee +
                '}';
    }
}
