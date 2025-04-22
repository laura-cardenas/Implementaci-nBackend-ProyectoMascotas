package com.tuempresa.gestionmascotas.repository;

import com.tuempresa.gestionmascotas.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}
