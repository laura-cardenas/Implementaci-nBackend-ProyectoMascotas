package com.tuempresa.gestionmascotas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class EventoMascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoEvento; // Ejemplo: Paseo, Vacuna, Alimentación
    private Date fechaEvento;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "mascota_id")
    @JsonBackReference
    private Mascota mascota;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTipoEvento() { return tipoEvento; }
    public void setTipoEvento(String tipoEvento) { this.tipoEvento = tipoEvento; }
    public Date getFechaEvento() { return fechaEvento; }
    public void setFechaEvento(Date fechaEvento) { this.fechaEvento = fechaEvento; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Mascota getMascota() { return mascota; }
    public void setMascota(Mascota mascota) { this.mascota = mascota; }
}
