package com.ejercicio.hito2.Repository;

import com.ejercicio.hito2.Model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    List<Artista> findByGenerosContaining(String genero);
    List<Artista> findByPaisDeOrigen(String paisDeOrigen);
    List<Artista> findByInstrumentosContaining(String instrumento);
    List<Artista> findByFechaDeFallecimientoIsNull();
    List<Artista> findByFechaDeFallecimientoIsNotNull();
}
