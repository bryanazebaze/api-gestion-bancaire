package com.example.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class Compte {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY) // Masque l'ID dans le formulaire de création
    private String id;

    @Schema(example = "Bryan Azebaze")
    private String titulaire;

    @Schema(example = "50000.0")
    private double solde;

    public Compte() {}

    public Compte(String id, String titulaire, double solde) {
        this.id = id;
        this.titulaire = titulaire;
        this.solde = solde;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitulaire() { return titulaire; }
    public void setTitulaire(String titulaire) { this.titulaire = titulaire; }
    public double getSolde() { return solde; }
    public void setSolde(double solde) { this.solde = solde; }
}