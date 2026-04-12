package com.example.practica2;

public class Pelicula {

    private String nombre;
    private String genero;
    private int anio;
    private String director;

    public Pelicula() {}

    public Pelicula(String nombre, String genero, int anio, String director) {
        this.nombre = nombre;
        this.genero = genero;
        this.anio = anio;
        this.director = director;
    }

    public String getNombre() { return nombre; }
    public String getGenero() { return genero; }
    public int getAnio() { return anio; }
    public String getDirector() { return director; }

    // 🔥 AGREGADO: setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setAnio(int anio) { this.anio = anio; }
    public void setDirector(String director) { this.director = director; }
}