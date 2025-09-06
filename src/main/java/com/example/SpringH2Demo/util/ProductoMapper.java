package com.example.SpringH2Demo.util;

import com.example.SpringH2Demo.dto.ProductoDTO;
import com.example.SpringH2Demo.model.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);

    // De entidad a DTO (para enviar a cliente)
    ProductoDTO toDTO(Producto producto);

    // De DTO a entidad (para guardar en BD)
    Producto toEntity(ProductoDTO productoDTO);
}