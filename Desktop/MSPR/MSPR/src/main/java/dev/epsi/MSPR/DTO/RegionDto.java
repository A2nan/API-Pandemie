package dev.epsi.MSPR.DTO;

import dev.epsi.MSPR.entities.Region;
import dev.epsi.MSPR.entities.Statistique;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class RegionDto {
    private Long id_region;
    private String nom_region;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private List<Long> statistiques;

    public RegionDto(Region region) {
        this.id_region = region.getId_region();
        this.nom_region = region.getNom_region();
        this.latitude = region.getLatitude();
        this.longitude = region.getLongitude();
        this.statistiques = region.getStatistiques() != null
                ? region.getStatistiques().stream().map(Statistique::getId).collect(Collectors.toList())
                : List.of();
    }

    public Long getId_region() {
        return id_region;
    }

    public String getNom_region() {
        return nom_region;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public List<Long> getStatistiques() {
        return statistiques;
    }
}
