package dev.epsi.MSPR.controllers;

import dev.epsi.MSPR.entities.Statistique;
import dev.epsi.MSPR.services.StatistiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statistiques")
public class StatistiqueController {
    @Autowired
    private StatistiqueService statistiqueService;

    @GetMapping
    public List<Statistique> getAllStatistiques() {
        return statistiqueService.getAllStatistiques();
    }

    @GetMapping("/{id}")
    public Statistique getStatistiqueById(@PathVariable Long id) {
        return statistiqueService.getStatistiqueById(id);
    }

    @PostMapping
    public Statistique createStatistique(@RequestBody Statistique statistique) {
        return statistiqueService.createStatistique(statistique);
    }

    @PutMapping("/{id}")
    public Statistique updateStatistique(@PathVariable Long id, @RequestBody Statistique statistiqueDetails) {
        return statistiqueService.updateStatistique(id, statistiqueDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteStatistique(@PathVariable Long id) {
        statistiqueService.deleteStatistique(id);
    }
}