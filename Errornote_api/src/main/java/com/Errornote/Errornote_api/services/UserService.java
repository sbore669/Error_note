package com.Errornote.Errornote_api.services;

import com.Errornote.Errornote_api.modele.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User ajouter(User user);
    Optional<User> modifier(Long id_user, User user);
    String supprimer(Long id_user);
    List<User> lire();
}
