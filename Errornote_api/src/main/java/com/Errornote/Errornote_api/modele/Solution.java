package com.Errornote.Errornote_api.modele;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_solution;
    private String ressource;
    private String temps_consacre;
    private String methodologie_adopte;

    @OneToOne
    @JoinColumn(name = "probleme_id_probleme")
    private Probleme probleme;


}
