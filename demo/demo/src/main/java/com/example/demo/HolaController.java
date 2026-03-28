package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @GetMapping("/")
    public String hola() {
        return "Hola mundo desde Spring Boot 🚀";
    }
    @GetMapping("/saludo")
    public String saludo() {
        return "Hola Cristian 👋";
    }
    @GetMapping("/nombre")
    public String nombre(String nombre) {
        return "Hola " + nombre + " 😎";
    }
    @GetMapping("/nom")
    public String nom(@RequestParam String nom) {
        return "Hola " + nom + " 😎";
    }
    @GetMapping("/user/{nombre}")
    public String user(@PathVariable String nombre) {
        return "Hola " + nombre;
    }
}