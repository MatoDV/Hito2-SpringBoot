package com.ejercicio.hito2.Service;

import com.ejercicio.hito2.Model.Disco;
import com.ejercicio.hito2.Repository.DiscoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DiscoService {
    @Autowired
    private DiscoRepository discoRepository;

    public Disco crearDisco(Disco disco) {
        return discoRepository.save(disco);
    }

    public Optional<Disco> buscarDiscoPorId(Long id) {
        return discoRepository.findById(id);
    }

    public List<Disco> buscarDiscoPorNombre(String nombre) {
        return discoRepository.findByNombreContaining(nombre);
    }

    public List<Disco> buscarDiscoPorGenero(String genero) {
        return discoRepository.findByGenerosContaining(genero);
    }

    public List<Disco> buscarDiscoPorFechaDeLanzamiento(LocalDate fechaDeLanzamiento) {
        return discoRepository.findByFechaDeLanzamiento(fechaDeLanzamiento);
    }

    public List<Disco> obtenerTodosLosDiscos(){
        return discoRepository.findAll();
    }
}
