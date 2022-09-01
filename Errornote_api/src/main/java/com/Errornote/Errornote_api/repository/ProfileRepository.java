package com.Errornote.Errornote_api.repository;

import com.Errornote.Errornote_api.modele.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByLibelle(String libelle);
}
