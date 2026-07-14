package com.example.entregaFinal.service;

import com.example.entregaFinal.model.Articulo;
import java.util.List;

public interface ArticuloService {
    List<Articulo> listarArticulos();
    Articulo obtenerArticuloPorId(Long id);
    Articulo guardarArticulo(Articulo articulo);
    Articulo actualizarArticulo(Long id, Articulo articulo);
    void eliminarArticulo(Long id);
}