package com.Errornote.Errornote_api.services;

import com.Errornote.Errornote_api.modele.Etat;

import java.util.List;

public interface EtatService {
    Etat ajouter (Etat etat);
    Etat modifier (Long id_etat);

    List<Etat> lire();
}
