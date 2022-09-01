package com.Errornote.Errornote_api.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Probleme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_probleme;
    private String titre;
    private String description;
    private String tecno_concerne;


    @ManyToOne
    @JoinColumn(name = "etat_id_etat")
    private Etat etat;

    @ManyToOne
    @JoinColumn(name = "user_id_user")
    private User user;
    @JsonIgnore
    @OneToOne(mappedBy = "probleme")
    @JoinColumn(name = "solution_id_solution")
    private Solution solution;
}
