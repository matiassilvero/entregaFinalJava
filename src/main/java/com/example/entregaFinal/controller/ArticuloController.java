package com.example.entregaFinal.controller;

import com.example.entregaFinal.model.Articulo;
import com.example.entregaFinal.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // Permite que cualquier página web se conecte(CORS)
@RestController 
@RequestMapping("/api/articulos") //Ruta
public class ArticuloController {

    private final ArticuloService articuloService;

    @Autowired
    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping({"", "/"})//Listar
    public List<Articulo> listar() {
        return articuloService.listarArticulos();
    }

    @GetMapping("/{id}")//Listar por ID
    public ResponseEntity<Articulo> obtenerPorId(@PathVariable Long id) {
        Articulo articulo = articuloService.obtenerArticuloPorId(id);
        return ResponseEntity.ok(articulo);
    }

    @PostMapping//Crear
    public Articulo crear(@RequestBody Articulo articulo) {
        return articuloService.guardarArticulo(articulo);
    }

    @PutMapping("/{id}")//Actualizar
    public ResponseEntity<Articulo> actualizar(@PathVariable Long id, @RequestBody Articulo articulo) {
        Articulo articuloActualizado = articuloService.actualizarArticulo(id, articulo);
        return ResponseEntity.ok(articuloActualizado);
    }

    @DeleteMapping("/{id}")//Borrar
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        articuloService.eliminarArticulo(id);
        return ResponseEntity.noContent().build();
    }
}