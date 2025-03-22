package dev.epsi.MSPR.controllers;

import dev.epsi.MSPR.entities.Maladie;
import dev.epsi.MSPR.services.MaladieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/maladies")
public class MaladieController {
    @Autowired
    private MaladieService maladieService;

    @GetMapping
    public List<Maladie> getAllMaladies() {
        return maladieService.getAllMaladies();
    }

    @GetMapping("/{id}")
    public Maladie getMaladieById(@PathVariable Long id) {
        return maladieService.getMaladieById(id);
    }

    @PostMapping
    public Maladie createMaladie(@RequestBody Maladie maladie) {
        return maladieService.createMaladie(maladie);
    }

    @PutMapping("/{id}")
    public Maladie updateMaladie(@PathVariable Long id, @RequestBody Maladie maladieDetails) {
        return maladieService.updateMaladie(id, maladieDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMaladie(@PathVariable Long id) {
        maladieService.deleteMaladie(id);
    }
}