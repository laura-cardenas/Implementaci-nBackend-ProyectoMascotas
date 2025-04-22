package com.tuempresa.gestionmascotas.dto;

import java.util.Date;

public class EventoMascotaDTO {

    private Long id;
    private String tipoEvento;
    private Date fechaEvento;
    private String descripcion;

    public EventoMascotaDTO(Long id, String tipoEvento, Date fechaEvento, String descripcion) {
        this.id = id;
        this.tipoEvento = tipoEvento;
        this.fechaEvento = fechaEvento;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipoEvento() { return tipoEvento; }
    public void setTipoEvento(String tipoEvento) { this.tipoEvento = tipoEvento; }

    public Date getFechaEvento() { return fechaEvento; }
    public void setFechaEvento(Date fechaEvento) { this.fechaEvento = fechaEvento; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
