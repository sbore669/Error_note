package com.Errornote.Errornote_api.services;

import com.Errornote.Errornote_api.modele.Profile;

public interface ProfileService {

    Profile ajouterProfil(Profile profile);
    Profile modifierProfile(Long id, Profile profile);
    Profile trouverProfilParLibelle(String libelle);
    void suprrimerProil(Long id);
}
