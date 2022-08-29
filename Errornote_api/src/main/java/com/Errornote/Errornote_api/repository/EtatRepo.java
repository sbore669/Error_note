package com.Errornote.Errornote_api.repository;

import com.Errornote.Errornote_api.modele.Etat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EtatRepo extends JpaRepository<Etat, Long> {
}
