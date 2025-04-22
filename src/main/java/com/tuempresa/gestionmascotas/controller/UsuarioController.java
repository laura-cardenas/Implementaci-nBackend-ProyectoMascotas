package com.tuempresa.gestionmascotas.controller;

import com.tuempresa.gestionmascotas.model.Usuario;
import com.tuempresa.gestionmascotas.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepo;

    public UsuarioController(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @GetMapping
    public List<Usuario> getAll() {
        return usuarioRepo.findAll();
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return usuarioRepo.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioRepo.deleteById(id);
    }
}
