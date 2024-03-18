package com.example.demo.service;

import com.example.demo.model.Duenio;
import com.example.demo.model.Mascota;
import com.example.demo.repository.DuenioRepository;
import com.example.demo.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

     @Autowired
     private MascotaRepository mascotaRepository;

     @Autowired
     private DuenioRepository duenioRepository;

    public Mascota obtenerMascotaPorId(Long id){
        return mascotaRepository.findById(id).orElseThrow(()-> new RuntimeException("no se encontro mascota"));
    }
     public List<Mascota> listarMascota(){
         //Sort sortBy= Sort.by(Sort.Direction.ASC,"nombre");
        return mascotaRepository.findAllOrderByNombreIgnoreCaseAsc();
     }
     public void guardarMascota(Mascota mascota,Long idDuenio){
         Duenio duenio = duenioRepository.findById(idDuenio).orElseThrow(()-> new RuntimeException("no se encontro el duenio"));
         mascota.setDuenio(duenio);
         mascotaRepository.save(mascota);
    }

    public void eliminarMascota(Long id){
        Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);

        if(mascotaOptional.isPresent()){
            mascotaRepository.delete(mascotaOptional.get());
        }
        else {
            throw new RuntimeException("Mascota no esncontrada");
        }
    }

    public void actualizarMascota(Long id, Mascota mascotaActualizada){
        Optional<Mascota> mascotaOptional = mascotaRepository.findById(id);
        if(mascotaOptional.isPresent()){
           Mascota mascotaExistente = mascotaOptional.get();
           mascotaExistente.setNombre(mascotaExistente.getNombre());
           mascotaExistente.setEdad(mascotaActualizada.getEdad());
           mascotaExistente.setEspecie(mascotaActualizada.getEspecie());
           mascotaExistente.setDuenio(mascotaActualizada.getDuenio());

           mascotaRepository.save(mascotaExistente);
        }
        else {
            throw new RuntimeException("Mascota no esncontrada");
        }
    }
}
