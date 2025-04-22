package com.tuempresa.gestionmascotas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "mascotas")
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String raza;
    private int edad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_dueño")
    private Propie dueño;

    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
     @JsonIgnore
    private List<EventoMascota> eventos;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public Propie getDueño() { return dueño; }
    public void setDueño(Propie dueño) { this.dueño = dueño; }

    public List<EventoMascota> getEventos() { return eventos; }
    public void setEventos(List<EventoMascota> eventos) { this.eventos = eventos; }
}
