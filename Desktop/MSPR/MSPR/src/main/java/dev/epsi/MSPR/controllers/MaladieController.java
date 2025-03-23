package dev.epsi.MSPR.controllers;

import dev.epsi.MSPR.entities.Maladie;
import dev.epsi.MSPR.services.MaladieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/maladies")
@Tag(name = "Maladie", description = "Gestion des maladies")
public class MaladieController {
    @Autowired
    private MaladieService maladieService;

    @GetMapping
    @Operation(summary = "Récupérer toutes les maladies", description = "Retourne une liste de toutes les maladies.")
    @ApiResponse(responseCode = "200", description = "Liste des maladies récupérée avec succès")
    public List<Maladie> getAllMaladies() {
        return maladieService.getAllMaladies();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer une maladie par ID", description = "Retourne les détails d'une maladie spécifique.")
    @ApiResponse(responseCode = "200", description = "Maladie récupérée avec succès")
    @ApiResponse(responseCode = "404", description = "Maladie non trouvée")
    public Maladie getMaladieById(@PathVariable Long id) {
        return maladieService.getMaladieById(id);
    }

    @PostMapping
    @Operation(summary = "Ajouter une maladie", description = "Ajoute une nouvelle maladie.")
    @ApiResponse(responseCode = "201", description = "Maladie créée avec succès")
    public Maladie createMaladie(@RequestBody Maladie maladie) {
        return maladieService.createMaladie(maladie);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour une maladie", description = "Met à jour les informations d'une maladie existante.")
    @ApiResponse(responseCode = "200", description = "Maladie mise à jour avec succès")
    @ApiResponse(responseCode = "404", description = "Maladie non trouvée")
    public Maladie updateMaladie(@PathVariable Long id, @RequestBody Maladie maladieDetails) {
        return maladieService.updateMaladie(id, maladieDetails);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une maladie", description = "Supprime une maladie existante.")
    @ApiResponse(responseCode = "204", description = "Maladie supprimée avec succès")
    @ApiResponse(responseCode = "404", description = "Maladie non trouvée")
    public void deleteMaladie(@PathVariable Long id) {
        maladieService.deleteMaladie(id);
    }
}