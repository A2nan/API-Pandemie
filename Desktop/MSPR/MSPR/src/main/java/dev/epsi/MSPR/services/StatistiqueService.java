package dev.epsi.MSPR.services;

import dev.epsi.MSPR.entities.Statistique;
import dev.epsi.MSPR.repositories.StatistiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StatistiqueService {
    @Autowired
    private StatistiqueRepository statistiqueRepository;

    public List<Statistique> getAllStatistiques() {

        return statistiqueRepository.findAll();
    }

    public Statistique getStatistiqueById(Long id) {

        return statistiqueRepository.findById(id).orElse(null);
    }

    public Statistique createStatistique(Statistique statistique) {

        return statistiqueRepository.save(statistique);
    }

    public Statistique updateStatistique(Long id, Statistique statistiqueDetails) {
        Statistique statistique = statistiqueRepository.findById(id).orElse(null);
        if (statistique != null) {
            statistique.setNouveau_mort(statistiqueDetails.getNouveau_mort());
            statistique.setNouveau_cas(statistiqueDetails.getNouveau_cas());
            statistique.setTotal_mort(statistiqueDetails.getTotal_mort());
            statistique.setTotal_cas(statistiqueDetails.getTotal_cas());
            return statistiqueRepository.save(statistique);
        }
        return null;
    }

    public void deleteStatistique(Long id) {
        statistiqueRepository.deleteById(id);
    }
}