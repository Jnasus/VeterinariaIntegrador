package com.huellitasChalacas.VeterinariaIntegrador.mapper;

import com.huellitasChalacas.VeterinariaIntegrador.dto.CategoriaProductoDTO;
import com.huellitasChalacas.VeterinariaIntegrador.model.CategoriaProducto;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author jtorr
 */
@Mapper(componentModel = "spring")
public interface CategoriaProductoMapper {
    
    // Mapeo de CategoriaProducto a CategoriaProductoDTO
    CategoriaProductoDTO toDTO(CategoriaProducto categoriaProducto);

    // Mapeo de CategoriaProductoDTO  a CategoriaProducto
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "productos", ignore = true)
    CategoriaProducto toEntity(CategoriaProductoDTO categoriaProductoDTO);

    // Método para mapear listas de CategoriaProducto a listas de CategoriaProductoDTO
    @IterableMapping(elementTargetType = CategoriaProductoDTO.class)
    List<CategoriaProductoDTO> toDtoList(List<CategoriaProducto> categoriaProductos);
}
