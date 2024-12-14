/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.mapper;

import com.huellitasChalacas.VeterinariaIntegrador.dto.ServicioDTO;
import com.huellitasChalacas.VeterinariaIntegrador.model.Servicio;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author jtorr
 */
@Mapper(componentModel = "spring", uses = TipoServicioMapper.class)
public interface ServicioMapper {

    @Mapping(target = "tipoServicioDTO", source = "tipoServicio")
    ServicioDTO toDto(Servicio servicio);

    @Mapping(target = "tipoServicio", source = "tipoServicioDTO")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "facturaDetalle", ignore = true)
    Servicio toEntity(ServicioDTO servicioDTO);
    
    @IterableMapping(elementTargetType = ServicioDTO.class)
    List<ServicioDTO> toDtoList(List<Servicio> servicios);
}
