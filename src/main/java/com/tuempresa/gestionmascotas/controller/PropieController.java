package com.tuempresa.gestionmascotas.controller;

import com.tuempresa.gestionmascotas.model.Propie;
import com.tuempresa.gestionmascotas.repository.PropietarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class PropieController {

    private final PropietarioRepository usuarioRepo;

    public PropieController(PropietarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @GetMapping
    public List<Propie> getAll() {
        return usuarioRepo.findAll();
    }

    @PostMapping
    public Propie create(@RequestBody Propie propie) {
        return usuarioRepo.save(propie);
    }

    @PutMapping("/{id}")
    public Propie update(@PathVariable Long id, @RequestBody Propie propie) {
        propie.setId(id);
        return usuarioRepo.save(propie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioRepo.deleteById(id);
    }
}
