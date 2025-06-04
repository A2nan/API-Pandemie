package dev.epsi.MSPR.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Schema(description = "Représente une maladie")
@Table(name = "maladie")
public class Maladie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID de la maladie", example = "1")
    private Long id_maladie;

    @Column(name = "nom_maladie", nullable = false)
    @Schema(description = "Nom de la maladie", example = "COVID-19")
    private String nom_maladie;

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
}