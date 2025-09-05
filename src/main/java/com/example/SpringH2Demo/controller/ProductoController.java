package com.example.SpringH2Demo.controller;

import com.example.SpringH2Demo.model.Producto;
import com.example.SpringH2Demo.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Producto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Producto create(@RequestBody Producto producto) {
        return service.save(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto producto) {
        return service.findById(id)
                .map(p -> {
                    p.setNombre(producto.getNombre());
                    p.setPrecio(producto.getPrecio());
                    return ResponseEntity.ok(service.save(p));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.findById(id)
                .map(p -> {
                    service.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //pull request

    @GetMapping("/filterByPrice")
    public List<Producto> filtrarPorPrecio(
            @RequestParam Double min,
            @RequestParam Double max) {
        return service.findByPrecioBetween(min, max);
    }


}