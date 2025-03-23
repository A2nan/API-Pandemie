package dev.epsi.MSPR.controllers;

import dev.epsi.MSPR.entities.Statistique;
import dev.epsi.MSPR.services.StatistiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statistiques")
@Tag(name = "Statistique", description = "Gestion des statistiques")
public class StatistiqueController {
    @Autowired
    private StatistiqueService statistiqueService;

    @GetMapping
    @Operation(summary = "Récupérer toutes les statistiques", description = "Retourne une liste de toutes les statistiques.")
    @ApiResponse(responseCode = "200", description = "Liste des statistiques récupérée avec succès")
    public List<Statistique> getAllStatistiques() {
        return statistiqueService.getAllStatistiques();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer une statistique par ID", description = "Retourne les détails d'une statistique spécifique.")
    @ApiResponse(responseCode = "200", description = "Statistique récupérée avec succès")
    @ApiResponse(responseCode = "404", description = "Statistique non trouvée")
    public Statistique getStatistiqueById(@PathVariable Long id) {
        return statistiqueService.getStatistiqueById(id);
    }

    @PostMapping
    @Operation(summary = "Ajouter une statistique", description = "Ajoute une nouvelle statistique.")
    @ApiResponse(responseCode = "201", description = "Statistique créée avec succès")
    public Statistique createStatistique(@RequestBody Statistique statistique) {
        return statistiqueService.createStatistique(statistique);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour une statistique", description = "Met à jour les informations d'une statistique existante.")
    @ApiResponse(responseCode = "200", description = "Statistique mise à jour avec succès")
    @ApiResponse(responseCode = "404", description = "Statistique non trouvée")
    public Statistique updateStatistique(@PathVariable Long id, @RequestBody Statistique statistiqueDetails) {
        return statistiqueService.updateStatistique(id, statistiqueDetails);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une statistique", description = "Supprime une statistique existante.")
    @ApiResponse(responseCode = "204", description = "Statistique supprimée avec succès")
    @ApiResponse(responseCode = "404", description = "Statistique non trouvée")
    public void deleteStatistique(@PathVariable Long id) {
        statistiqueService.deleteStatistique(id);
    }
}