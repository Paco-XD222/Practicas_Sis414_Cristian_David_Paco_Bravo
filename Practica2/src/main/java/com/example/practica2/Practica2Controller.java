package com.example.practica2;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

// 🔥 Swagger
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Peliculas", description = "Operaciones relacionadas con películas")
@RestController
public class Practica2Controller {

    List<Pelicula> lista = new ArrayList<>();

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

    @Operation(summary = "Verificar si la API está funcionando")
    @GetMapping("/")
    public String inicio() {
        return "API de peliculas funcionando 🚀";
    }

    @Operation(summary = "Mensaje sobre el futuro")
    @GetMapping("/futuro")
    public String futuro() {
        return "En 5 años me veo como ingeniero en sistemas 🚀";
    }

    @Operation(summary = "Buscar una película con 4 parámetros")
    @GetMapping("/pelicula")
    public Object buscarPelicula(
            @Parameter(description = "Nombre") @RequestParam String nombre,
            @Parameter(description = "Genero") @RequestParam String genero,
            @Parameter(description = "Año") @RequestParam int anio,
            @Parameter(description = "Director") @RequestParam String director) {

        for (Pelicula p : lista) {
            if (p.getNombre().equalsIgnoreCase(nombre) &&
                    p.getGenero().equalsIgnoreCase(genero) &&
                    p.getAnio() == anio &&
                    p.getDirector().equalsIgnoreCase(director)) {

                return p;
            }
        }

        return "No existe ❌";
    }

    @Operation(summary = "Obtener todas las películas")
    @GetMapping("/peliculas")
    public List<Pelicula> obtenerTodas() {
        return lista;
    }

    @Operation(summary = "Agregar una película")
    @PostMapping("/pelicula")
    public String agregarPelicula(@RequestBody Pelicula pelicula) {

        for (Pelicula p : lista) {
            if (p.getNombre().equalsIgnoreCase(pelicula.getNombre())) {
                return "La película ya existe ❌";
            }
        }

        lista.add(pelicula);
        return "Película agregada ✔";
    }

    // 🔥 PUT
    @Operation(summary = "Actualizar una película")
    @PutMapping("/pelicula")
    public String actualizarPelicula(@RequestBody Pelicula pelicula) {

        for (Pelicula p : lista) {
            if (p.getNombre().equalsIgnoreCase(pelicula.getNombre())) {

                p.setGenero(pelicula.getGenero());
                p.setAnio(pelicula.getAnio());
                p.setDirector(pelicula.getDirector());

                return "Película actualizada ✔";
            }
        }

        return "No existe ❌";
    }

    // 🔥 DELETE
    @Operation(summary = "Eliminar una película")
    @DeleteMapping("/pelicula")
    public String eliminarPelicula(@RequestParam String nombre) {

        for (Pelicula p : lista) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                lista.remove(p);
                return "Película eliminada 🗑";
            }
        }

        return "No existe ❌";
    }
}