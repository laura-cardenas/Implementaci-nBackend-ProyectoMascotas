package com.tuempresa.gestionmascotas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String raza;

    private int edad;

    @ManyToOne
    @JoinColumn(name = "id_dueño")
    private Usuario dueño;

    // Constructor vacío
    public Mascota() {}

    // Constructor con parámetros
    public Mascota(String nombre, String raza, int edad, Usuario dueño) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.dueño = dueño;
    }

    // Getters y Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRaza() { return raza; }

    public void setRaza(String raza) { this.raza = raza; }

    public int getEdad() { return edad; }

    public void setEdad(int edad) { this.edad = edad; }

    public Usuario getDueño() { return dueño; }

    public void setDueño(Usuario dueño) { this.dueño = dueño; }
}
