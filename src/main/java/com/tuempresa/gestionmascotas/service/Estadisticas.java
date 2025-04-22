/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuempresa.gestionmascotas.service;



import com.tuempresa.gestionmascotas.model.RecorridoMascota;
import com.tuempresa.gestionmascotas.repository.EventoMascotaRepository;
import com.tuempresa.gestionmascotas.repository.RecorridoMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuempresa.gestionmascotas.model.EventoMascota;

import java.util.List;
import java.util.Date;

@Service
public class Estadisticas {

    @Autowired
    private EventoMascotaRepository eventoRepo;
    @Autowired
    private RecorridoMascotaRepository recorridoRepo;

    // Número total de eventos por mascota
    public long obtenerEventosTotal(Long mascotaId) {
        return eventoRepo.countByMascotaId(mascotaId);
    }

    // Promedio de recorrido diario
    public double promedioRecorrido(Long mascotaId) {
        List<RecorridoMascota> recorridos = recorridoRepo.findByMascotaId(mascotaId);
        return recorridos.stream().mapToDouble(RecorridoMascota::getDistancia).average().orElse(0);
    }

    // Número de vacunas por rango de fecha
    public long obtenerVacunasPorFecha(Long mascotaId, Date inicio, Date fin) {
        return eventoRepo.countByTipoEventoAndMascotaIdAndFechaEventoBetween("Vacuna", mascotaId, inicio, fin);
    }

    // Número de visitas al veterinario
    public long obtenerVisitasVeterinario(Long mascotaId) {
        return eventoRepo.countByTipoEventoAndMascotaId("Visita Veterinario", mascotaId);
    }
}
