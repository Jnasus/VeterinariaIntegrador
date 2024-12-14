/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.mapper;

import com.huellitasChalacas.VeterinariaIntegrador.dto.ProductoDTO;
import com.huellitasChalacas.VeterinariaIntegrador.model.Producto;
import org.mapstruct.Mapper;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author jtorr
 */
@Mapper(componentModel = "spring", uses = CategoriaProductoMapper.class)
public interface ProductoMapper {
    
    
    @Mapping(target = "categoriaProductoDTO", source = "categoria")
    ProductoDTO toDto(Producto producto);

    @Mapping(target = "categoria", source = "categoriaProductoDTO")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "facturaDetalle", ignore = true)
    Producto toEntity(ProductoDTO productoDTO);
    
    @IterableMapping(elementTargetType = ProductoDTO.class)
    List<ProductoDTO> toDtoList(List<Producto> productos);
}
