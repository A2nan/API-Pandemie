package dev.epsi.MSPR.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dev.epsi.MSPR.config.BigDecimalSerializer;
import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Schema(description = "Représente une région")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID de la région", example = "1")
    private Long id_region;

    @Schema(description = "Nom de la région", example = "Île-de-France")
    private String nom_region;

    // 👇 Type : BigDecimal
    @Column(precision = 10, scale = 6)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal latitude;

    @Column(precision = 10, scale = 6)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal longitude;

    @ManyToOne
    @JoinColumn(name = "id_pays")
    @JsonBackReference // 🔁 côté enfant de la relation Pays → Région
    @Schema(description = "Pays associé à la région")
    private Pays pays;

    @OneToMany(mappedBy = "region")
    @JsonManagedReference // 🔁 côté parent de la relation Région → Statistique
    @Schema(description = "Liste des statistiques associées à la région")
    private List<Statistique> statistiques;

    // Getters & Setters
    public Long getId_region() {
        return id_region;
    }

    public void setId_region(Long id_region) {
        this.id_region = id_region;
    }

    public String getNom_region() {
        return nom_region;
    }

    public void setNom_region(String nom_region) {
        this.nom_region = nom_region;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public List<Statistique> getStatistiques() {
        return statistiques;
    }

    public void setStatistiques(List<Statistique> statistiques) {
        this.statistiques = statistiques;
    }
}
