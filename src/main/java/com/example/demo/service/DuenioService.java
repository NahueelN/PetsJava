package com.example.demo.service;

import com.example.demo.model.Duenio;
import com.example.demo.repository.DuenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenioService {

    @Autowired
    private DuenioRepository duenioRepository;

    public Duenio obtenerDuenioPorId(Long id){
        return duenioRepository.findById(id).orElseThrow(()-> new RuntimeException("no se encontro duenio"));
    }

    public List<Duenio> listarDuenios(){
        return duenioRepository.findAll();
    }

    public Duenio guardarDuenio(Duenio duenio){
        return duenioRepository.save(duenio);
    }

}
