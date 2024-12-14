/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.mapper;

import com.huellitasChalacas.VeterinariaIntegrador.dto.TipoServicioDTO;
import com.huellitasChalacas.VeterinariaIntegrador.model.TipoServicio;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


/**
 *
 * @author jtorr
 */
@Mapper(componentModel = "spring")
public interface TipoServicioMapper {
    // Mapeo de TipoServicio a TipoServicioDTO
    TipoServicioDTO toDTO(TipoServicio tipoServicio);

    // Mapeo de TipoServicioDTO  a TipoServicio
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "servicios", ignore = true)
    TipoServicio toEntity(TipoServicioDTO tipoServicioDTO);

    // Método para mapear listas de TipoServicio a listas de TipoServicioDTO
    @IterableMapping(elementTargetType = TipoServicioDTO.class)
    List<TipoServicioDTO> toDtoList(List<TipoServicio> tipoServicios);
}
