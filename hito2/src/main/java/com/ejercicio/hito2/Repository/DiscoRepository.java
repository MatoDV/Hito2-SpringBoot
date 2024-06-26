package com.ejercicio.hito2.Repository;

import com.ejercicio.hito2.Model.Disco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DiscoRepository extends JpaRepository<Disco, Long> {
    List<Disco> findByNombreContaining(String nombre);
    List<Disco> findByGenerosContaining(String genero);
    List<Disco> findByFechaDeLanzamiento(LocalDate fechaDeLanzamiento);
}
