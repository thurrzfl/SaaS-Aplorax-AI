// DietaService.java
package com.aplorax.service;

import com.aplorax.dto.DietaRequestDTO;
import com.aplorax.model.Alimento;
import com.aplorax.model.Dieta;
import com.aplorax.model.Refeicao;
import com.aplorax.repository.DietaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DietaService {

    private final DietaRepository dietaRepository;

    public Dieta criar(DietaRequestDTO dto) {
        Dieta dieta = new Dieta();
        dieta.setNome(dto.getNome());
        dieta.setCaloriasAlvo(dto.getCaloriasAlvo());
        dieta.setObjetivo(dto.getObjetivo());
        dieta.setProteinaTotalG(dto.getProteinaTotalG());
        dieta.setCarboidratoTotalG(dto.getCarboidratoTotalG());
        dieta.setGorduraTotalG(dto.getGorduraTotalG());

        List<Refeicao> refeicoes = dto.getRefeicoes().stream()
                .map(r -> {
                    Refeicao refeicao = new Refeicao();
                    refeicao.setNomeRefeicao(r.getNomeRefeicao());
                    refeicao.setOrdem(r.getOrdem());
                    refeicao.setDieta(dieta);

                    List<Alimento> alimentos = r.getAlimentos().stream()
                            .map(a -> {
                                Alimento alimento = new Alimento();
                                alimento.setNome(a.getNome());
                                alimento.setQuantidade(a.getQuantidade());
                                alimento.setUnidade(a.getUnidade());
                                alimento.setKcal(a.getKcal());
                                alimento.setProteinaG(a.getProteinaG());
                                alimento.setCarboidratoG(a.getCarboidratoG());
                                alimento.setGorduraG(a.getGorduraG());
                                alimento.setRefeicao(refeicao);
                                return alimento;
                            })
                            .collect(Collectors.toList());

                    refeicao.setAlimentos(alimentos);
                    return refeicao;
                })
                .collect(Collectors.toList());

        dieta.setRefeicoes(refeicoes);

        return dietaRepository.save(dieta);
    }

    public List<Dieta> listarTodos() {
        return dietaRepository.findAll();
    }

    public Dieta buscarPorId(Long id) {
        return dietaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dieta não encontrada"));
    }

    public List<Dieta> filtrarPorObjetivo(Dieta.Objetivo objetivo) {
        return dietaRepository.findByObjetivo(objetivo);
    }

    public List<Dieta> filtrarPorCalorias(Integer calorias) {
        return dietaRepository.findByCaloriasAlvo(calorias);
    }

    public List<Dieta> filtrarPorFaixaCalorica(Integer min, Integer max) {
        return dietaRepository.findByCaloriasAlvoBetween(min, max);
    }
}