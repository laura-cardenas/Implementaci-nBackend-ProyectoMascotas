/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuempresa.gestionmascotas.controller;


import com.tuempresa.gestionmascotas.model.Veterinario;
import com.tuempresa.gestionmascotas.repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
public class VeterinarioController {

    @Autowired
    private VeterinarioRepository repo;

    @GetMapping
    public List<Veterinario> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Veterinario crear(@RequestBody Veterinario v) {
        return repo.save(v);
    }

    @PutMapping("/{id}")
    public Veterinario actualizar(@PathVariable Long id, @RequestBody Veterinario datos) {
        Veterinario v = repo.findById(id).orElseThrow();
        v.setNombre(datos.getNombre());
        v.setCorreo(datos.getCorreo());
        v.setEspecialidad(datos.getEspecialidad());
        return repo.save(v);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
