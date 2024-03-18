package com.example.demo.repository;

import com.example.demo.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota,Long> {
//todo: implemetar metodos presonalizados
    Optional<Mascota> findByNombre(String nombre);
    @Query("SELECT m FROM Mascota m ORDER BY LOWER(m.nombre) ASC")
    List<Mascota> findAllOrderByNombreIgnoreCaseAsc();
}
