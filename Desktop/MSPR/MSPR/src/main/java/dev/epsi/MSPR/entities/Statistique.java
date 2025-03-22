package dev.epsi.MSPR.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class Statistique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_maladie")
    private Maladie maladie;

    @ManyToOne
    @JoinColumn(name = "id_region")
    private Region region;

    private LocalDate date;
    private int nouveau_mort;
    private int nouveau_cas;
    private int nouveau_rétabli;
    private int total_mort;
    private int total_cas;
    private int total_rétabli;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Maladie getMaladie() {
        return maladie;
    }

    public void setMaladie(Maladie maladie) {
        this.maladie = maladie;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNouveau_mort() {
        return nouveau_mort;
    }

    public void setNouveau_mort(int nouveau_mort) {
        this.nouveau_mort = nouveau_mort;
    }

    public int getNouveau_cas() {
        return nouveau_cas;
    }

    public void setNouveau_cas(int nouveau_cas) {
        this.nouveau_cas = nouveau_cas;
    }

    public int getNouveau_rétabli() {
        return nouveau_rétabli;
    }

    public void setNouveau_rétabli(int nouveau_rétabli) {
        this.nouveau_rétabli = nouveau_rétabli;
    }

    public int getTotal_mort() {
        return total_mort;
    }

    public void setTotal_mort(int total_mort) {
        this.total_mort = total_mort;
    }

    public int getTotal_cas() {
        return total_cas;
    }

    public void setTotal_cas(int total_cas) {
        this.total_cas = total_cas;
    }

    public int getTotal_rétabli() {
        return total_rétabli;
    }

    public void setTotal_rétabli(int total_rétabli) {
        this.total_rétabli = total_rétabli;
    }
}