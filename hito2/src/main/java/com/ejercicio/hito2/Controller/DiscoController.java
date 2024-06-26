package com.ejercicio.hito2.Controller;

import com.ejercicio.hito2.Model.Disco;
import com.ejercicio.hito2.Service.DiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/discos")
public class DiscoController {
    @Autowired
    private DiscoService discoService;

    @PostMapping
    public ResponseEntity<Disco> crearDisco(@RequestBody Disco disco) {
        Disco nuevoDisco = discoService.crearDisco(disco);
        return ResponseEntity.ok(nuevoDisco);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disco> obtenerDiscoPorId(@PathVariable Long id) {
        Optional<Disco> disco = discoService.buscarDiscoPorId(id);
        return disco.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Disco>> buscarDiscosPorNombre(@PathVariable String nombre) {
        List<Disco> discos = discoService.buscarDiscoPorNombre(nombre);
        return ResponseEntity.ok(discos);
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Disco>> buscarDiscosPorGenero(@PathVariable String genero) {
        List<Disco> discos = discoService.buscarDiscoPorGenero(genero);
        return ResponseEntity.ok(discos);
    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<Disco>> buscarDiscosPorFecha(@PathVariable String fecha) {
        LocalDate fechaDeLanzamiento = LocalDate.parse(fecha);
        List<Disco> discos = discoService.buscarDiscoPorFechaDeLanzamiento(fechaDeLanzamiento);
        return ResponseEntity.ok(discos);
    }

    @GetMapping
    public ResponseEntity<List<Disco>> obtenerTodosLosDiscos() {
        List<Disco> discos = discoService.obtenerTodosLosDiscos();
        return ResponseEntity.ok(discos);
    }
}
