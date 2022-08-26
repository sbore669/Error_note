package com.Errornote.Errornote_api.repository;

import com.Errornote.Errornote_api.modele.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepo extends JpaRepository<Commentaire, Long> {
}
