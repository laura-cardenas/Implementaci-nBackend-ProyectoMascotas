/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuempresa.gestionmascotas.model;


import jakarta.persistence.*;
import java.util.Date;

@Entity
public class RecorridoMascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double distancia; // Distancia recorrida en kilómetros
    private Date fechaRecorrido;

    @ManyToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getDistancia() { return distancia; }
    public void setDistancia(Double distancia) { this.distancia = distancia; }
    public Date getFechaRecorrido() { return fechaRecorrido; }
    public void setFechaRecorrido(Date fechaRecorrido) { this.fechaRecorrido = fechaRecorrido; }
    public Mascota getMascota() { return mascota; }
    public void setMascota(Mascota mascota) { this.mascota = mascota; }
}

