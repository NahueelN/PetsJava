package com.example.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // toString,equeals,gettes setters hashcore
@NoArgsConstructor
@AllArgsConstructor
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;

    @NotBlank(message = "la especie no puede estar en blanco")
    private String especie;

    @NotEmpty(message = "la edad no puede estar vacia")
    private int edad;

    @ManyToOne

    @NotEmpty(message = "debe tener un dueño asociado")
    private Duenio duenio;


}
