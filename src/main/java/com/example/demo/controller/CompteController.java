package com.example.demo.controller;

import com.example.demo.model.Compte;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    // Notre "base de données" temporaire (une simple liste)
    private List<Compte> listeComptes = new ArrayList<>();

    // 1. Créer un compte
    @PostMapping
    public Compte creerCompte(@RequestBody Compte compte) {
        // On génère un ID unique automatiquement
        compte.setId(UUID.randomUUID().toString());
        listeComptes.add(compte);
        return compte;
    }

    // 2. Afficher tous les comptes
    @GetMapping
    public List<Compte> afficherTousLesComptes() {
        return listeComptes;
    }
}