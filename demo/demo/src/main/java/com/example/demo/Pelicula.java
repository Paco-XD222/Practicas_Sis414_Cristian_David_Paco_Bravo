package com.example.demo;

public class Pelicula {

    private String nombre;
    private String genero;
    private int anio;
    private String director;

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
}