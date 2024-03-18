package com.example.demo.repository;

import com.example.demo.model.Duenio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuenioRepository extends JpaRepository<Duenio,Long> {
    //todo: implemetar metodos de busqueda
}
