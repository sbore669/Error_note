package com.Errornote.Errornote_api.services;

import com.Errornote.Errornote_api.modele.Probleme;

import java.util.List;
import java.util.Optional;

public interface ProblemeService {
    Probleme ajouter(Probleme probleme);
    Optional<Probleme> modifier(Long id_probleme, Probleme probleme);
    String supprimer(Long id_probleme);
    List<Probleme> lire();
}
