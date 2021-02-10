package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private MicroserviceProduitsProxy ProduitsProxy;

    @Autowired
    private MicroserviceCommandeProxy CommandesProxy;

    @RequestMapping("/")
    public String accueil(Model model){

        List<ProductBean> produits =  ProduitsProxy.listeDesProduits();

        model.addAttribute("produits", produits);

        return "Accueil";
    }

    @RequestMapping("/details-produit/{id}")
    public String ficheProduit(@PathVariable int id, Model model){

        ProductBean produit = ProduitsProxy.recupererUnProduit(id);

        model.addAttribute("produit", produit);

        return "FicheProduit";
    }
    @RequestMapping("/details-produit/commander-produit/{id}")
    public String CommanderProduit(@PathVariable int id, Model model){

        CommandeBean commande = new CommandeBean(null, id, null, 1, false);
        CommandesProxy.ajouterCommande(commande);

        model.addAttribute("commande", commande);

        return "FicheCommande";
    }
}
