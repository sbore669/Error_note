package com.Errornote.Errornote_api.modele;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Etat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id_etat;
    private String status;


    /*@ManyToOne
    @JoinColumn(name = "probleme_id_probleme")
    private Probleme probleme;*/
}
