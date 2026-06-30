
package com.aplorax.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "alimentos")
public class Alimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double quantidade;

    @Column(nullable = false)
    private String unidade;

    @Column(nullable = false)
    private Double kcal;

    @Column(nullable = false)
    private Double proteinaG;

    @Column(nullable = false)
    private Double carboidratoG;

    @Column(nullable = false)
    private Double gorduraG;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "refeicao_id", nullable = false)
    private Refeicao refeicao;
}