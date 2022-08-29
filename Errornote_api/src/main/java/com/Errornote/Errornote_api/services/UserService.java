package com.Errornote.Errornote_api.services;

import com.Errornote.Errornote_api.modele.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User CreerUser(User user);
    Optional<User> modifier(Long id_user, User user);
    String supprimer(Long id_user);
    List<User> lire();
    boolean Seconnecter(String pseudo, String password);
}
