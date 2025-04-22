package com.tuempresa.gestionmascotas.service;

import com.tuempresa.gestionmascotas.model.Usuario;
import com.tuempresa.gestionmascotas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para actualizar un usuario
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        // Verifica si el usuario existe
        Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        // Actualiza los datos del usuario
        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setCorreo(usuario.getCorreo());
        // Guardar los cambios en la base de datos
        return usuarioRepository.save(usuarioExistente);
    }

    // Método para eliminar un usuario
    public void eliminarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarioRepository.delete(usuario);
    }
}
