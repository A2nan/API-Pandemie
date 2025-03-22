package dev.epsi.MSPR.repositories;

import dev.epsi.MSPR.entities.Statistique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatistiqueRepository extends JpaRepository<Statistique, Long> {
}