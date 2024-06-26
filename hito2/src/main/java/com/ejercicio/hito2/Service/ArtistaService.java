package com.ejercicio.hito2.Service;

import com.ejercicio.hito2.Model.Artista;
import com.ejercicio.hito2.Repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepository;

    public Artista crearArtista(Artista artista) {
    return artistaRepository.save(artista);
}
    public Optional<Artista> obtenerArtistaPorId(Long id) {
        return artistaRepository.findById(id);
    }

    public List<Artista> obtenerArtistasPorGenero(String genero){
        return  artistaRepository.findByGenerosContaining(genero);
    }

    public List<Artista> obtenerArtistaPorNacionalidad(String paisDeOrigen){
        return artistaRepository.findByPaisDeOrigen(paisDeOrigen);
    }

    public List<Artista> obtenerArtistaPorInstrumento(String instrumento){
        return artistaRepository.findByInstrumentosContaining(instrumento);
    }

    public List<Artista> obtenerArtistasVivos(){
        return artistaRepository.findByFechaDeFallecimientoIsNull();
    }

    public List<Artista> obtenerArtistasMuertos(){
        return artistaRepository.findByFechaDeFallecimientoIsNotNull();
    }

    public List<Artista> obtenerTodosLosArtistas(){
        return artistaRepository.findAll();
    }
}
