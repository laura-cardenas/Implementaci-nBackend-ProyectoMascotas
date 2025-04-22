/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuempresa.gestionmascotas.repository;


import com.tuempresa.gestionmascotas.model.EventoMascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EventoMascotaRepository extends JpaRepository<EventoMascota, Long> {
    long countByMascotaId(Long mascotaId);
    long countByTipoEventoAndMascotaIdAndFechaEventoBetween(String tipoEvento, Long mascotaId, Date inicio, Date fin);
    long countByTipoEventoAndMascotaId(String tipoEvento, Long mascotaId);
    List<EventoMascota> findByMascotaId(Long mascotaId);

}

