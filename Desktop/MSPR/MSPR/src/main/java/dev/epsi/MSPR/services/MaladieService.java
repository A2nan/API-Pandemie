package dev.epsi.MSPR.services;

import dev.epsi.MSPR.entities.Maladie;
import dev.epsi.MSPR.repositories.MaladieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MaladieService {
    @Autowired
    private MaladieRepository maladieRepository;

    public List<Maladie> getAllMaladies() {

        return maladieRepository.findAll();
    }

    public Maladie getMaladieById(Long id) {

        return maladieRepository.findById(id).orElse(null);
    }

    public Maladie createMaladie(Maladie maladie) {

        return maladieRepository.save(maladie);
    }

    public Maladie updateMaladie(Long id, Maladie maladieDetails) {
        Maladie maladie = maladieRepository.findById(id).orElse(null);
        if (maladie != null) {
            maladie.setNom_maladie(maladieDetails.getNom_maladie());
            return maladieRepository.save(maladie);
        }
        return null;
    }

    public void deleteMaladie(Long id) {
        maladieRepository.deleteById(id);
    }
}