// Dieta.java
package com.aplorax.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "dietas")
public class Dieta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer caloriasAlvo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Objetivo objetivo;

    private Double proteinaTotalG;

    private Double carboidratoTotalG;

    private Double gorduraTotalG;

    @OneToMany(mappedBy = "dieta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Refeicao> refeicoes = new ArrayList<>();

    // Enum
    public enum Objetivo {
        LOSE_WEIGHT,
        MAINTAIN,
        GAIN_MUSCLE
    }
}