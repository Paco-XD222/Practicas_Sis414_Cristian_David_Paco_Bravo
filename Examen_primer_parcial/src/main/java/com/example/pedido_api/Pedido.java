package com.example.pedido_api;

public class Pedido {

    private String fecha;
    private String cliente;
    private double total;
    private String estado;
    private String direccionEntrega;

    public Pedido() {}

    public Pedido(String fecha, String cliente, double total, String estado, String direccionEntrega) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.total = total;
        this.estado = estado;
        this.direccionEntrega = direccionEntrega;
    }

    public String getFecha() { return fecha; }
    public String getCliente() { return cliente; }
    public double getTotal() { return total; }
    public String getEstado() { return estado; }
    public String getDireccionEntrega() { return direccionEntrega; }

    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public void setTotal(double total) { this.total = total; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setDireccionEntrega(String direccionEntrega) { this.direccionEntrega = direccionEntrega; }
}