// TreinoRequestDTO.java
package com.aplorax.dto;

import com.aplorax.model.Treino;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class TreinoRequestDTO {

    @NotBlank
    private String nome;

    private String descricao;

    @NotNull
    private Treino.CategoriaTreino categoria;

    @NotNull
    private Treino.NivelTreino nivel;

    @NotEmpty
    private List<ExercicioItemDTO> exercicios;

    public static class ExercicioItemDTO {
        @NotBlank
        private String nomeExercicio;
        private Integer series;
        private Integer repeticoes;
        private Integer descansoSegundos;
        private String observacoes;

        // Getters e Setters
        public String getNomeExercicio() {
            return nomeExercicio;
        }

        public void setNomeExercicio(String nomeExercicio) {
            this.nomeExercicio = nomeExercicio;
        }

        public Integer getSeries() {
            return series;
        }

        public void setSeries(Integer series) {
            this.series = series;
        }

        public Integer getRepeticoes() {
            return repeticoes;
        }

        public void setRepeticoes(Integer repeticoes) {
            this.repeticoes = repeticoes;
        }

        public Integer getDescansoSegundos() {
            return descansoSegundos;
        }

        public void setDescansoSegundos(Integer descansoSegundos) {
            this.descansoSegundos = descansoSegundos;
        }

        public String getObservacoes() {
            return observacoes;
        }

        public void setObservacoes(String observacoes) {
            this.observacoes = observacoes;
        }
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Treino.CategoriaTreino getCategoria() {
        return categoria;
    }

    public void setCategoria(Treino.CategoriaTreino categoria) {
        this.categoria = categoria;
    }

    public Treino.NivelTreino getNivel() {
        return nivel;
    }

    public void setNivel(Treino.NivelTreino nivel) {
        this.nivel = nivel;
    }

    public List<ExercicioItemDTO> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<ExercicioItemDTO> exercicios) {
        this.exercicios = exercicios;
    }
}