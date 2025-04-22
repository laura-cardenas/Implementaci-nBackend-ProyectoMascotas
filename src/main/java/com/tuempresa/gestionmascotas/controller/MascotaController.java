package com.tuempresa.gestionmascotas.controller;

import com.tuempresa.gestionmascotas.model.Mascota;
import com.tuempresa.gestionmascotas.model.Propie;
import com.tuempresa.gestionmascotas.repository.MascotaRepository;
import com.tuempresa.gestionmascotas.repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private PropietarioRepository propietarioRepository;

    @GetMapping
    public List<Mascota> obtenerTodasLasMascotas() {
        return mascotaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mascota obtenerMascotaPorId(@PathVariable Long id) {
        return mascotaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Mascota crearMascota(@RequestBody Mascota mascota) {
        Long idDueño = mascota.getDueño().getId();

        // Recuperar el Propie real desde la base de datos
        Propie dueño = propietarioRepository.findById(idDueño)
                .orElseThrow(() -> new RuntimeException("Dueño no encontrado con ID: " + idDueño));

        mascota.setDueño(dueño);
        return mascotaRepository.save(mascota);
    }

    @PutMapping("/{id}")
    public Mascota actualizarMascota(@PathVariable Long id, @RequestBody Mascota mascotaActualizada) {
        Mascota mascota = mascotaRepository.findById(id).orElse(null);
        if (mascota != null) {
            mascota.setNombre(mascotaActualizada.getNombre());
            mascota.setRaza(mascotaActualizada.getRaza());
            mascota.setEdad(mascotaActualizada.getEdad());

            // Recuperar el dueño completo
            Long idDueño = mascotaActualizada.getDueño().getId();
            Propie dueño = propietarioRepository.findById(idDueño)
                    .orElseThrow(() -> new RuntimeException("Dueño no encontrado con ID: " + idDueño));
            mascota.setDueño(dueño);

            return mascotaRepository.save(mascota);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarMascota(@PathVariable Long id) {
        mascotaRepository.deleteById(id);
    }
}
