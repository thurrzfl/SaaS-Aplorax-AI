
// DietaRequestDTO.java
package com.aplorax.dto;

import com.aplorax.model.Dieta;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class DietaRequestDTO {

    @NotBlank
    private String nome;

    @NotNull
    private Integer caloriasAlvo;

    @NotNull
    private Dieta.Objetivo objetivo;

    private Double proteinaTotalG;
    private Double carboidratoTotalG;
    private Double gorduraTotalG;

    @NotEmpty
    @Valid
    private List<RefeicaoItemDTO> refeicoes;

    public static class RefeicaoItemDTO {
        @NotBlank
        private String nomeRefeicao;

        @NotNull
        private Integer ordem;

        @NotEmpty
        @Valid
        private List<AlimentoItemDTO> alimentos;

        // Getters e Setters
        public String getNomeRefeicao() {
            return nomeRefeicao;
        }

        public void setNomeRefeicao(String nomeRefeicao) {
            this.nomeRefeicao = nomeRefeicao;
        }

        public Integer getOrdem() {
            return ordem;
        }

        public void setOrdem(Integer ordem) {
            this.ordem = ordem;
        }

        public List<AlimentoItemDTO> getAlimentos() {
            return alimentos;
        }

        public void setAlimentos(List<AlimentoItemDTO> alimentos) {
            this.alimentos = alimentos;
        }
    }

    public static class AlimentoItemDTO {
        @NotBlank
        private String nome;

        @NotNull
        private Double quantidade;

        @NotBlank
        private String unidade;

        @NotNull
        private Double kcal;

        @NotNull
        private Double proteinaG;

        @NotNull
        private Double carboidratoG;

        @NotNull
        private Double gorduraG;

        // Getters e Setters
        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Double getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(Double quantidade) {
            this.quantidade = quantidade;
        }

        public String getUnidade() {
            return unidade;
        }

        public void setUnidade(String unidade) {
            this.unidade = unidade;
        }

        public Double getKcal() {
            return kcal;
        }

        public void setKcal(Double kcal) {
            this.kcal = kcal;
        }

        public Double getProteinaG() {
            return proteinaG;
        }

        public void setProteinaG(Double proteinaG) {
            this.proteinaG = proteinaG;
        }

        public Double getCarboidratoG() {
            return carboidratoG;
        }

        public void setCarboidratoG(Double carboidratoG) {
            this.carboidratoG = carboidratoG;
        }

        public Double getGorduraG() {
            return gorduraG;
        }

        public void setGorduraG(Double gorduraG) {
            this.gorduraG = gorduraG;
        }
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCaloriasAlvo() {
        return caloriasAlvo;
    }

    public void setCaloriasAlvo(Integer caloriasAlvo) {
        this.caloriasAlvo = caloriasAlvo;
    }

    public Dieta.Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Dieta.Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public Double getProteinaTotalG() {
        return proteinaTotalG;
    }

    public void setProteinaTotalG(Double proteinaTotalG) {
        this.proteinaTotalG = proteinaTotalG;
    }

    public Double getCarboidratoTotalG() {
        return carboidratoTotalG;
    }

    public void setCarboidratoTotalG(Double carboidratoTotalG) {
        this.carboidratoTotalG = carboidratoTotalG;
    }

    public Double getGorduraTotalG() {
        return gorduraTotalG;
    }

    public void setGorduraTotalG(Double gorduraTotalG) {
        this.gorduraTotalG = gorduraTotalG;
    }

    public List<RefeicaoItemDTO> getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(List<RefeicaoItemDTO> refeicoes) {
        this.refeicoes = refeicoes;
    }
}