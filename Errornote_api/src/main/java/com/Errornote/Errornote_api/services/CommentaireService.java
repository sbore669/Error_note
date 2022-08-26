package com.Errornote.Errornote_api.services;


import com.Errornote.Errornote_api.modele.Commentaire;

import java.util.List;

public interface CommentaireService {
    Commentaire ajouter(Commentaire commentaire);
    Commentaire modifier(Long id_commentaire, Commentaire commentaire);
    String supprimer(Long id_commentaire);
    List<Commentaire> lire();

}
