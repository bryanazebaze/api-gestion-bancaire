package com.example.demo.model; // Vérifie bien que ce nom correspond à ton projet

public class Compte {
    private String id;
    private String titulaire;
    private double solde;

    // Constructeur vide (nécessaire pour que Spring puisse lire le JSON)
    public Compte() {
    }

    // Constructeur avec paramètres
    public Compte(String id, String titulaire, double solde) {
        this.id = id;
        this.titulaire = titulaire;
        this.solde = solde;
    }

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(String titulaire) {
        this.titulaire = titulaire;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
}