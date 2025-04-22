package com.tuempresa.gestionmascotas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Propie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String correo;

    // Constructor vacío
    public Propie() {}

    // Constructor con parámetros
    public Propie(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    // Getters y Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }

    public void setCorreo(String correo) { this.correo = correo; }
}
