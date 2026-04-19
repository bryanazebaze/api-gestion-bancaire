package com.example.demo.controller;

import com.example.demo.model.Compte;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    // Notre "base de données" temporaire
    private List<Compte> listeComptes = new ArrayList<>();

    // 1. Créer un compte
    @PostMapping
    public Compte creerCompte(@RequestBody Compte compte) {
        compte.setId(UUID.randomUUID().toString());
        listeComptes.add(compte);
        return compte;
    }

    // 2. Afficher tous les comptes
    @GetMapping
    public List<Compte> afficherTousLesComptes() {
        return listeComptes;
    }

    // 3. Effectuer un dépôt
    @PostMapping("/{id}/deposer/{montant}")
    public Compte deposer(@PathVariable String id, @PathVariable double montant) {
        for (Compte c : listeComptes) {
            if (c.getId().equals(id)) {
                c.setSolde(c.getSolde() + montant);
                return c;
            }
        }
        throw new RuntimeException("Compte introuvable !");
    }

    // 4. Effectuer un retrait
    @PostMapping("/{id}/retirer/{montant}")
    public Compte retirer(@PathVariable String id, @PathVariable double montant) {
        for (Compte c : listeComptes) {
            if (c.getId().equals(id)) {
                if (c.getSolde() >= montant) {
                    c.setSolde(c.getSolde() - montant);
                    return c;
                } else {
                    throw new RuntimeException("Solde insuffisant pour effectuer ce retrait !");
                }
            }
        }
        throw new RuntimeException("Compte introuvable !");
    }
}