package com.example.entregaFinal.repository;

import com.example.entregaFinal.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Conecta con la base de datos y maneja operaciones sobre la entidad Articulo
@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
}