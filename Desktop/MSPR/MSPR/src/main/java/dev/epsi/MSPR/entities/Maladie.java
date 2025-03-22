package dev.epsi.MSPR.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Maladie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_maladie;
    private String nom_maladie;

    @OneToMany(mappedBy = "maladie")
    private List<Statistique> statistiques;

    public Long getId_maladie() {
        return id_maladie;
    }

    public void setId_maladie(Long id_maladie) {
        this.id_maladie = id_maladie;
    }

    public String getNom_maladie() {
        return nom_maladie;
    }

    public void setNom_maladie(String nom_maladie) {
        this.nom_maladie = nom_maladie;
    }

    public List<Statistique> getStatistiques() {
        return statistiques;
    }

    public void setStatistiques(List<Statistique> statistiques) {
        this.statistiques = statistiques;
    }
}