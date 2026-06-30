// TreinoController.java
package com.aplorax.controller;

import com.aplorax.dto.TreinoRequestDTO;
import com.aplorax.model.Treino;
import com.aplorax.service.TreinoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treinos")
@RequiredArgsConstructor
public class TreinoController {

    private final TreinoService treinoService;

    @PostMapping
    public ResponseEntity<Treino> criar(@Valid @RequestBody TreinoRequestDTO dto) {
        Treino treino = treinoService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(treino);
    }

    @GetMapping
    public ResponseEntity<List<Treino>> listar(
            @RequestParam(required = false) Treino.CategoriaTreino categoria,
            @RequestParam(required = false) Treino.NivelTreino nivel) {

        List<Treino> treinos;

        if (categoria != null && nivel != null) {
            treinos = treinoService.filtrarPorCategoriaENivel(categoria, nivel);
        } else if (categoria != null) {
            treinos = treinoService.filtrarPorCategoria(categoria);
        } else if (nivel != null) {
            treinos = treinoService.filtrarPorNivel(nivel);
        } else {
            treinos = treinoService.listarTodos();
        }

        return ResponseEntity.ok(treinos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Treino> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(treinoService.buscarPorId(id));
    }
}