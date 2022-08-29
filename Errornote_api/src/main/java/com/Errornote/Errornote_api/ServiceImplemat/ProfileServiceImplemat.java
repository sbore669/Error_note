package com.Errornote.Errornote_api.ServiceImplemat;

import com.Errornote.Errornote_api.modele.Profile;
import com.Errornote.Errornote_api.repository.ProfileRepository;
import com.Errornote.Errornote_api.services.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImplemat implements ProfileService {

    @Autowired
    ProfileRepository profileRepository;
    @Override
    public Profile ajouterProfil(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile modifierProfile(Long id, Profile profile) {
        return profileRepository.findById(id).map(profile1 -> {
            profile1.setLibelle(profile.getLibelle());
            return profileRepository.save(profile);
        }).orElseThrow(() -> new RuntimeException("Erreur au niveau de modification"));
    }

    @Override
    public Profile trouverProfilParLibelle(String libelle) {
        return null;
    }

    @Override
    public void suprrimerProil(Long id) {
     profileRepository.deleteById(id);
    }
}
