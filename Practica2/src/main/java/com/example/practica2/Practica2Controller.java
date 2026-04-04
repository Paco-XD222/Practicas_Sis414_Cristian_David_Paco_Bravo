package com.example.practica2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Practica2Controller {

    // 🔥 LISTA GLOBAL
    List<Pelicula> lista = new ArrayList<>();

    // 🔹 CONSTRUCTOR (para cargar datos iniciales)
    public Practica2Controller() {
        lista.add(new Pelicula("Interstellar", "Ciencia Ficcion", 2014, "Christopher Nolan"));
        lista.add(new Pelicula("Oppenheimer", "Drama", 2023, "Christopher Nolan"));
        lista.add(new Pelicula("Regreso al Futuro", "Ciencia Ficcion", 1985, "Robert Zemeckis"));
        lista.add(new Pelicula("Avengers", "Accion", 2012, "Joss Whedon"));
        lista.add(new Pelicula("IT", "Terror", 2017, "Andy Muschietti"));
        lista.add(new Pelicula("Capitan America", "Accion", 2011, "Joe Johnston"));
        lista.add(new Pelicula("Iron Man", "Accion", 2008, "Jon Favreau"));
        lista.add(new Pelicula("Batman", "Accion", 2008, "Christopher Nolan"));
        lista.add(new Pelicula("Spiderman", "Accion", 2002, "Sam Raimi"));
        lista.add(new Pelicula("Doctor Strange", "Fantasia", 2016, "Scott Derrickson"));
    }
    // verificaion render
    @GetMapping("/")
    public String inicio() {
        return "API de peliculas funcionando 🚀";
    }
    // 🔹 SIN parámetros
    @GetMapping("/futuro")
    public String futuro() {
        return "En 5 años me veo como ingeniero en sistemas trabajando en proyectos grandes 🚀";
    }

    // 🔹 CON parámetros
    @GetMapping("/pelicula")
    public Object buscarPelicula(
            @RequestParam String nombre,
            @RequestParam String genero,
            @RequestParam int anio,
            @RequestParam String director) {

        for (Pelicula p : lista) {
            if (p.getNombre().equalsIgnoreCase(nombre) &&
                    p.getGenero().equalsIgnoreCase(genero) &&
                    p.getAnio() == anio &&
                    p.getDirector().equalsIgnoreCase(director)) {

                return p;
            }
        }

        return "no existe";
    }

    //  POST
    @PostMapping("/pelicula")
    public String agregarPelicula(@RequestBody Pelicula pelicula) {

        for (Pelicula p : lista) {
            if (p.getNombre().equalsIgnoreCase(pelicula.getNombre()) &&
                    p.getGenero().equalsIgnoreCase(pelicula.getGenero()) &&
                    p.getAnio() == pelicula.getAnio() &&
                    p.getDirector().equalsIgnoreCase(pelicula.getDirector())) {

                return "La pelicula ya existe ❌";
            }
        }

        lista.add(pelicula);
        return "Pelicula agregada correctamente 🎬";
    }
}