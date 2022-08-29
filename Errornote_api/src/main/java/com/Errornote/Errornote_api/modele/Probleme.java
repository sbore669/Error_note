package com.Errornote.Errornote_api.modele;

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


    @OneToOne
    @JoinColumn(name = "solution_id_solution")
    private Solution solution;
}
