package com.ejercicio.hito2.Controller;

import com.ejercicio.hito2.Model.Artista;
import com.ejercicio.hito2.Service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {
    @Autowired
    private ArtistaService artistaService;

    @PostMapping
    public ResponseEntity<Artista> crearArtista(@RequestBody Artista artista) {
        Artista nuevoArtista = artistaService.crearArtista(artista);
        return ResponseEntity.ok(nuevoArtista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artista> obtenerArtistaPorId(@PathVariable long id) {
        Optional<Artista> artista = artistaService.obtenerArtistaPorId(id);
        return artista.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Artista>> obtenerArtistaPorGenero(@PathVariable String genero) {
        List<Artista>artistas = artistaService.obtenerArtistasPorGenero(genero);
        return ResponseEntity.ok(artistas);
    }

    @GetMapping("/pais/{pais}")
    public ResponseEntity<List<Artista>> obtenerArtistasPorNacionalidad(@PathVariable String pais) {
        List<Artista> artistas = artistaService.obtenerArtistaPorNacionalidad(pais);
        return ResponseEntity.ok(artistas);
    }

    @GetMapping("/instrumento/{instrumento}")
    public ResponseEntity<List<Artista>> obtenerArtistasPorInstrumento(@PathVariable String instrumento) {
        List<Artista> artistas = artistaService.obtenerArtistaPorInstrumento(instrumento);
        return ResponseEntity.ok(artistas);
    }

    @GetMapping("/vivos")
    public ResponseEntity<List<Artista>> obtenerArtistasVivos() {
        List<Artista> artistas = artistaService.obtenerArtistasVivos();
        return ResponseEntity.ok(artistas);
    }

    @GetMapping("/fallecidos")
    public ResponseEntity<List<Artista>> obtenerArtistasFallecidos() {
        List<Artista> artistas = artistaService.obtenerArtistasMuertos();
        return ResponseEntity.ok(artistas);
    }

    @GetMapping
    public ResponseEntity<List<Artista>> obtenerTodosLosArtistas() {
        List<Artista> artistas = artistaService.obtenerTodosLosArtistas();
        return ResponseEntity.ok(artistas);
    }
}
