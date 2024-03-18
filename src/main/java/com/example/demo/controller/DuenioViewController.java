package com.example.demo.controller;

import com.example.demo.model.Duenio;
import com.example.demo.service.DuenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DuenioViewController {

    @Autowired
    private DuenioService duenioService;

    @GetMapping("/duenios")
    public String listarDuenios(Model model) {


        List<Duenio> duenios = duenioService.listarDuenios();
        model.addAttribute("duenios",duenios);
        return "duenios";
    }

    @GetMapping("/agregarDuenio")
    public String mostrarFormularioAgregarDuenio(Model model){
        model.addAttribute("duenio",new Duenio());
        return "agregarDuenio";
    }

    @PostMapping("/guardarDuenio")
    public String guardarDuenio(@ModelAttribute Duenio duenio){
        duenioService.guardarDuenio(duenio);
        return "redirect:/duenios";
    }














}
