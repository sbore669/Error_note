package com.Errornote.Errornote_api.repository;

import com.Errornote.Errornote_api.modele.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Long> {
    User findByPseudo(String pseudo);
    User findByPassword(String password);
}
