package dev.epsi.MSPR.repositories;

import dev.epsi.MSPR.entities.Maladie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaladieRepository extends JpaRepository<Maladie, Long> {}