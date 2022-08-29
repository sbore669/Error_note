package com.Errornote.Errornote_api.ServiceImplemat;

import com.Errornote.Errornote_api.modele.Commentaire;
import com.Errornote.Errornote_api.repository.CommentaireRepo;
import com.Errornote.Errornote_api.services.CommentaireService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
@AllArgsConstructor
public class CommentaireServImpl implements CommentaireService {
    private final CommentaireRepo commentaireRepo;
    @Override
    public Commentaire ajouter(Commentaire commentaire) {

        return commentaireRepo.save(commentaire);
    }

    @Override
    public Commentaire modifier(Long id_commentaire, Commentaire commentaire) {
        return commentaireRepo.findById(id_commentaire)
                .map(commentaire1 -> {
                    commentaire1.setCommentaire(commentaire.getCommentaire());
                    return commentaireRepo.save(commentaire1);
                }).orElseThrow(() -> new RuntimeException("Commentaire non trouvé"));
    }

    @Override
    public String supprimer(Long id_commentaire) {
        commentaireRepo.deleteById(id_commentaire);
        return "Vous venez de supprimé votre commentaire";
    }

    @Override
    public List<Commentaire> lire() {
        return commentaireRepo.findAll();
    }
}
