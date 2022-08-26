package com.Errornote.Errornote_api.ServiceImplemat;

import com.Errornote.Errornote_api.modele.Commentaire;
import com.Errornote.Errornote_api.modele.Probleme;
import com.Errornote.Errornote_api.repository.ProblemeRepo;
import com.Errornote.Errornote_api.services.ProblemeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ProblemServImpl implements ProblemeService {

    private final ProblemeRepo problemeRepo;
    @Override
    public Probleme ajouter(Probleme probleme) {
        return problemeRepo.save(probleme);
    }

    @Override
    public Optional<Probleme> modifier(Long id_probleme, Probleme probleme) {
        return Optional.ofNullable(problemeRepo.findById(id_probleme)
                .map(probleme1 -> {
                    probleme1.setDescription(probleme.getDescription());
                    probleme1.setTitre(probleme.getTitre());
                    probleme1.setTecno_concerne(probleme.getTecno_concerne());
                    return problemeRepo.save(probleme);
                }).orElseThrow(() -> new RuntimeException("Probleme modifier")));
    }

    @Override
    public String supprimer(Long id_probleme) {
        problemeRepo.deleteById(id_probleme);
        return "Vous venez de supprimé un probleme";
    }

    @Override
    public List<Probleme> lire() {
        return problemeRepo.findAll();
    }
}
