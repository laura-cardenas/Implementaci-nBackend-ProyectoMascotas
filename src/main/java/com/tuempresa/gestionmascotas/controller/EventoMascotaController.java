/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuempresa.gestionmascotas.controller;


import com.tuempresa.gestionmascotas.model.EventoMascota;
import com.tuempresa.gestionmascotas.repository.EventoMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@CrossOrigin("*")
public class EventoMascotaController {

    @Autowired
    private EventoMascotaRepository repo;

    @GetMapping
    public List<EventoMascota> listar() {
        return repo.findAll();
    }

    @PostMapping
    public EventoMascota crear(@RequestBody EventoMascota evento) {
        return repo.save(evento);
    }

    @PutMapping("/{id}")
    public EventoMascota actualizar(@PathVariable Long id, @RequestBody EventoMascota evento) {
        EventoMascota e = repo.findById(id).orElseThrow();
        e.setTipoEvento(evento.getTipoEvento());
        e.setFechaEvento(evento.getFechaEvento());
        e.setDescripcion(evento.getDescripcion());
        return repo.save(e);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }
    @GetMapping("/mascota/{mascotaId}")
public List<EventoMascota> obtenerEventosPorMascota(@PathVariable Long mascotaId) {
    return repo.findByMascotaId(mascotaId);
}

}

