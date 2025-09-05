package com.example.SpringH2Demo.service;

import com.example.SpringH2Demo.model.Producto;
import com.example.SpringH2Demo.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> findAll() {
        return repository.findAll();
    }

    public Optional<Producto> findById(Long id) {
        return repository.findById(id);
    }

    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Producto> findByPrecioBetween(Double min, Double max) {
        return repository.findByPrecioBetween(min, max);
    }
}