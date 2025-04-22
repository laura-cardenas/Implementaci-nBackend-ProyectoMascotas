package com.tuempresa.gestionmascotas.mapper;

import com.tuempresa.gestionmascotas.model.Mascota;
import com.tuempresa.gestionmascotas.model.EventoMascota;
import com.tuempresa.gestionmascotas.dto.MascotaDTO;
import com.tuempresa.gestionmascotas.dto.EventoMascotaDTO;
import java.util.List;
import java.util.stream.Collectors;

public class MascotaMapper {

    public static MascotaDTO toDTO(Mascota mascota) {
        List<EventoMascotaDTO> eventosDTO = mascota.getEventos().stream()
                .map(evento -> new EventoMascotaDTO(evento.getId(), evento.getTipoEvento(), evento.getFechaEvento(), evento.getDescripcion()))
                .collect(Collectors.toList());
        
        return new MascotaDTO(mascota.getId(), mascota.getNombre(), mascota.getRaza(), mascota.getEdad(), 
                              mascota.getDueño().getNombre(), eventosDTO);
    }
}
