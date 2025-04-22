/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuempresa.gestionmascotas.controller;


import com.tuempresa.gestionmascotas.model.Cuidador;
import com.tuempresa.gestionmascotas.repository.CuidadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuidadores")
public class CuidadorController {

    @Autowired
    private CuidadorRepository repo;

    @GetMapping
    public List<Cuidador> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Cuidador crear(@RequestBody Cuidador c) {
        return repo.save(c);
    }

    @PutMapping("/{id}")
    public Cuidador actualizar(@PathVariable Long id, @RequestBody Cuidador datos) {
        Cuidador c = repo.findById(id).orElseThrow();
        c.setNombre(datos.getNombre());
        c.setZona(datos.getZona());
        c.setTelefono(datos.getTelefono());
        return repo.save(c);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}

