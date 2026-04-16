package com.example.pedido_api;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pedidos", description = "CRUD de pedidos")
@RestController
public class PedidoController {

    List<Pedido> lista = new ArrayList<>();

    public PedidoController() {
        lista.add(new Pedido("2026-04-16", "Juan", 150, "Pendiente", "La Paz"));
        lista.add(new Pedido("2026-04-17", "Maria", 200, "Entregado", "El Alto"));
        lista.add(new Pedido("2026-04-18", "Cristian", 200, "Entregado", "Potosí"));
    }

    @Operation(summary = "Verificar API")
    @GetMapping("/")
    public String inicio() {
        return "API de pedidos funcionando 🚀";
    }

    @Operation(summary = "Obtener todos los pedidos")
    @GetMapping("/pedidos")
    public List<Pedido> obtenerTodos() {
        return lista;
    }

    @Operation(summary = "Buscar pedido por cliente")
    @GetMapping("/pedido")
    public Object buscar(@RequestParam String cliente) {
        for (Pedido p : lista) {
            if (p.getCliente().equalsIgnoreCase(cliente)) {
                return p;
            }
        }
        return "No existe ❌";
    }

    @Operation(summary = "Agregar pedido")
    @PostMapping("/pedido")
    public String agregar(@RequestBody Pedido pedido) {
        for (Pedido p : lista) {
            if (p.getCliente().equalsIgnoreCase(pedido.getCliente())) {
                return "Ya existe ❌";
            }
        }
        lista.add(pedido);
        return "Agregado ✔";
    }

    @Operation(summary = "Actualizar pedido")
    @PutMapping("/pedido")
    public String actualizar(@RequestBody Pedido pedido) {
        for (Pedido p : lista) {
            if (p.getCliente().equalsIgnoreCase(pedido.getCliente())) {

                p.setFecha(pedido.getFecha());
                p.setTotal(pedido.getTotal());
                p.setEstado(pedido.getEstado());
                p.setDireccionEntrega(pedido.getDireccionEntrega());

                return "Actualizado ✔";
            }
        }
        return "No existe ❌";
    }

    @Operation(summary = "Eliminar pedido")
    @DeleteMapping("/pedido")
    public String eliminar(@RequestParam String cliente) {
        for (Pedido p : lista) {
            if (p.getCliente().equalsIgnoreCase(cliente)) {
                lista.remove(p);
                return "Eliminado 🗑";
            }
        }
        return "No existe ❌";
    }
}