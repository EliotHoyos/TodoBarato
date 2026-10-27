package com.todobarato.pcl.todobarato.repository;

import com.todobarato.pcl.todobarato.model.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarcaRepository extends JpaRepository<Marca,Integer> {
    Optional<Marca> findByNombre(String nombre);
    List<Marca> findByEstadoTrue();
}
