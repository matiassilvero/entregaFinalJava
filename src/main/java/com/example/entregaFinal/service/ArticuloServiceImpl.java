package com.example.entregaFinal.service;

import com.example.entregaFinal.model.Articulo;
import com.example.entregaFinal.repository.ArticuloRepository;
import com.example.entregaFinal.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Le dice a Spring que esta clase es un Servicio
public class ArticuloServiceImpl implements ArticuloService {

    private final ArticuloRepository articuloRepository;

    @Autowired
    public ArticuloServiceImpl(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    @Override
    public List<Articulo> listarArticulos() {
        return articuloRepository.findAll();
    }

    @Override
    public Articulo obtenerArticuloPorId(Long id) {
        return articuloRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ese artículo " + id + " no se encuentra"));
    }

    @Override
    public Articulo guardarArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    @Override
    public Articulo actualizarArticulo(Long id, Articulo nArticulo) {
        Articulo articulo = articuloRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se puede actualizar. El artículo con el ID " + id + " no se encuentra"));

        articulo.setNombre(nArticulo.getNombre());
        articulo.setPrecio(nArticulo.getPrecio());

        return articuloRepository.save(articulo);
    }

    @Override
    public void eliminarArticulo(Long id) {
        Articulo articulo = articuloRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se puede eliminar. Ese articulo " + id + " no se encuentra"));
        articuloRepository.delete(articulo);
    }
}