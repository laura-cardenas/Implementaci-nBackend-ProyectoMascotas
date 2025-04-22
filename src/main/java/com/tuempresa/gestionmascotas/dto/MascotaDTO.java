package com.tuempresa.gestionmascotas.dto;

import java.util.List;

public class MascotaDTO {

    private Long id;
    private String nombre;
    private String raza;
    private int edad;
    private String dueñoNombre;
    private List<EventoMascotaDTO> eventos;

    public MascotaDTO(Long id, String nombre, String raza, int edad, String dueñoNombre, List<EventoMascotaDTO> eventos) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.dueñoNombre = dueñoNombre;
        this.eventos = eventos;
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

    public String getDueñoNombre() { return dueñoNombre; }
    public void setDueñoNombre(String dueñoNombre) { this.dueñoNombre = dueñoNombre; }

    public List<EventoMascotaDTO> getEventos() { return eventos; }
    public void setEventos(List<EventoMascotaDTO> eventos) { this.eventos = eventos; }
}
