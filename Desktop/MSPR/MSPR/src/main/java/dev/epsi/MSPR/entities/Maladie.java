package dev.epsi.MSPR.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity // Indique que cette classe est une entité JPA
@Table(name = "maladie") // Optionnel : spécifie le nom de la table dans la base de données
public class Maladie {
    @Id // Indique que ce champ est la clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génère automatiquement la valeur de l'ID
    private Long id_maladie;

    @Column(name = "nom_maladie", nullable = false) // Optionnel : spécifie le nom de la colonne et les contraintes
    private String nom_maladie;

    @OneToMany(mappedBy = "maladie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Statistique> statistiques;

    // Getters et Setters
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