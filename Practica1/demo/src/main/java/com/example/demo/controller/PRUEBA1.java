package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PRUEBA1 {
    @GetMapping("/mensaje")
    public String mensaje (){
        return "Hola, estoy aprendiendo Spring Boot";
    }
    @GetMapping("/saludos")
    public String saludo (){
        return "hola Juan ";
    }
    @GetMapping("/info")
    public String info(){
        return "Mi nombre es Juan y estoy Aprendiendo bakend";
    }
    @GetMapping("/salu/{nombre}")
    public String salu(@PathVariable String nombre){
        return "mi nombre es " + nombre;
    }

}
