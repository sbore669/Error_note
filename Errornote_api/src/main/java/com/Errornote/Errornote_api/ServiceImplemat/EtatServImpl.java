package com.Errornote.Errornote_api.ServiceImplemat;

import com.Errornote.Errornote_api.modele.Etat;
import com.Errornote.Errornote_api.repository.EtatRepo;
import com.Errornote.Errornote_api.services.EtatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class EtatServImpl implements EtatService {
    private final EtatRepo etatRepo;
    @Override
    public Etat ajouter(Etat etat) {
        return etatRepo.save(etat);
    }

    @Override
    public Etat modifier(Long id_etat) {
        return etatRepo.findById(id_etat)
                .map(etat1 -> {

                    etat1.setStatus(etat1.getStatus());
                    return etatRepo.save(etat1);
                }).orElseThrow(() -> new RuntimeException("Commentaire non trouvé"));
    }

    @Override
    public List<Etat> lire() {
        return etatRepo.findAll();
    }
}
