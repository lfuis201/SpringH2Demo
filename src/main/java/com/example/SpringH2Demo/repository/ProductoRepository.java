package com.example.SpringH2Demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SpringH2Demo.model.Producto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByPrecioBetween(Double min, Double max);

}