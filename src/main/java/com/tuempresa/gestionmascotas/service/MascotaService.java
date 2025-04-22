package com.tuempresa.gestionmascotas.service;

import com.tuempresa.gestionmascotas.model.Mascota;
import com.tuempresa.gestionmascotas.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    // Método para actualizar una mascota
    public Mascota actualizarMascota(Long id, Mascota mascota) {
        // Verifica si la mascota existe
        Mascota mascotaExistente = mascotaRepository.findById(id).orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
        // Actualiza los datos de la mascota
        mascotaExistente.setNombre(mascota.getNombre());
        mascotaExistente.setRaza(mascota.getRaza());
        // Guardar los cambios en la base de datos
        return mascotaRepository.save(mascotaExistente);
    }

    // Método para eliminar una mascota
    public void eliminarMascota(Long id) {
        Mascota mascota = mascotaRepository.findById(id).orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
        mascotaRepository.delete(mascota);
    }
}
