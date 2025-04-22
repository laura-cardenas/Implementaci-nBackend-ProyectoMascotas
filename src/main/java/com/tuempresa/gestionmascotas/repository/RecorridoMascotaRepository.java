/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tuempresa.gestionmascotas.repository;


import com.tuempresa.gestionmascotas.model.RecorridoMascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecorridoMascotaRepository extends JpaRepository<RecorridoMascota, Long> {
    List<RecorridoMascota> findByMascotaId(Long mascotaId);
}

