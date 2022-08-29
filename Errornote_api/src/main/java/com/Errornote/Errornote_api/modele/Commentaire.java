package com.Errornote.Errornote_api.modele;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Setter
@Getter
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_commentaire;
    private String commentaire;


    @ManyToOne
    private Solution solution;

    @ManyToOne
    private User user;
}
