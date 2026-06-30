// TreinoService.java
package com.aplorax.service;

import com.aplorax.dto.TreinoRequestDTO;
import com.aplorax.model.Exercicio;
import com.aplorax.model.Treino;
import com.aplorax.repository.TreinoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TreinoService {

    private final TreinoRepository treinoRepository;

    public Treino criar(TreinoRequestDTO dto) {
        Treino treino = new Treino();
        treino.setNome(dto.getNome());
        treino.setDescricao(dto.getDescricao());
        treino.setCategoria(dto.getCategoria());
        treino.setNivel(dto.getNivel());

        List<Exercicio> exercicios = dto.getExercicios().stream()
                .map(e -> {
                    Exercicio exercicio = new Exercicio();
                    exercicio.setNomeExercicio(e.getNomeExercicio());
                    exercicio.setSeries(e.getSeries());
                    exercicio.setRepeticoes(e.getRepeticoes());
                    exercicio.setDescansoSegundos(e.getDescansoSegundos());
                    exercicio.setObservacoes(e.getObservacoes());
                    exercicio.setTreino(treino);
                    return exercicio;
                })
                .collect(Collectors.toList());

        treino.setExercicios(exercicios);

        return treinoRepository.save(treino);
    }

    public List<Treino> listarTodos() {
        return treinoRepository.findAll();
    }

    public Treino buscarPorId(Long id) {
        return treinoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treino não encontrado"));
    }

    public List<Treino> filtrarPorCategoria(Treino.CategoriaTreino categoria) {
        return treinoRepository.findByCategoria(categoria);
    }

    public List<Treino> filtrarPorNivel(Treino.NivelTreino nivel) {
        return treinoRepository.findByNivel(nivel);
    }

    public List<Treino> filtrarPorCategoriaENivel(Treino.CategoriaTreino categoria, Treino.NivelTreino nivel) {
        return treinoRepository.findByCategoriaAndNivel(categoria, nivel);
    }
}