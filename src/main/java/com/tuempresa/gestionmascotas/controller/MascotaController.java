package com.tuempresa.gestionmascotas.controller;

import com.tuempresa.gestionmascotas.model.Mascota;
import com.tuempresa.gestionmascotas.repository.MascotaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    private final MascotaRepository mascotaRepo;

    public MascotaController(MascotaRepository mascotaRepo) {
        this.mascotaRepo = mascotaRepo;
    }

    @GetMapping
    public List<Mascota> getAll() {
        return mascotaRepo.findAll();
    }

    @PostMapping
    public Mascota create(@RequestBody Mascota mascota) {
        return mascotaRepo.save(mascota);
    }

    @PutMapping("/{id}")
    public Mascota update(@PathVariable Long id, @RequestBody Mascota mascota) {
        mascota.setId(id);
        return mascotaRepo.save(mascota);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        mascotaRepo.deleteById(id);
    }
}
