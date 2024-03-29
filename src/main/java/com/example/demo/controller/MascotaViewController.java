package com.example.demo.controller;


import com.example.demo.model.Mascota;
import com.example.demo.service.DuenioService;
import com.example.demo.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MascotaViewController {

    @Autowired
    private DuenioService duenioService;

    @Autowired
    private MascotaService mascotaService;

    @GetMapping("/")
    public String redirectToMascotas(){
        return "redirect:/mascotas";
    }

    @GetMapping("/mascotas")
    public String listarMascotas(Model model){
        List<Mascota> mascotas = mascotaService.listarMascota();
        model.addAttribute("mascotas",mascotas);
        return "mascotas";
    }

    @GetMapping("/agregarMascota")
    public String mostrarFormularioAgregarMascota(Model model){
        model.addAttribute( "duenios", duenioService.listarDuenios());
        return "agregarMascota";
    }


    @PostMapping("/guardarMascota")
    public String guardarMascota(@ModelAttribute Mascota mascota, @RequestParam Long idDuenio){
        mascotaService.guardarMascota(mascota,idDuenio);
        return "redirect:/mascotas";
    }

    @GetMapping("/eliminarMascota/{id}")
    public String eliminarMascota(@PathVariable Long id){
        mascotaService.eliminarMascota(id);
        return "redirect:/mascotas";
    }

    @GetMapping("/actualizarMascota/{id}")
    public String mostrarFormularioActualizarMascota(@PathVariable Long id,Model model){
        Mascota mascota = mascotaService.obtenerMascotaPorId(id);
        model.addAttribute("mascota",mascota);
        model.addAttribute("duenios",duenioService.listarDuenios());
        return "actualizarMascota";
    }

    @PostMapping("/actualizarMascota/{id}")
    public String actualizarMascota(@PathVariable Long id, @ModelAttribute Mascota mascotaActualizada,@RequestParam Long idDuenio){
        mascotaActualizada.setDuenio(duenioService.obtenerDuenioPorId(idDuenio));
        mascotaService.actualizarMascota(id,mascotaActualizada);
        return "redirect:/mascotas";
    }

}
