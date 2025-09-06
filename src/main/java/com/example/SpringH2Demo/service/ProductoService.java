package com.example.SpringH2Demo.service;

import com.example.SpringH2Demo.dto.ProductoDTO;
import com.example.SpringH2Demo.model.Producto;
import com.example.SpringH2Demo.repository.ProductoRepository;
import com.example.SpringH2Demo.util.ProductoMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository repository;
    private final ProductoMapper mapper;

    public ProductoService(ProductoRepository repository, ProductoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
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

    public ProductoDTO createProductDTO(ProductoDTO dto) {
        Producto entity = mapper.toEntity(dto);
        Producto guardado = repository.save(entity);
        return mapper.toDTO(guardado);
    }

    public Producto findByIdOrThrow(Long id) throws ChangeSetPersister.NotFoundException {
        return repository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}