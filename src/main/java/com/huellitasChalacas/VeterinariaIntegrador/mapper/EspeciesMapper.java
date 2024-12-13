/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.mapper;

import com.huellitasChalacas.VeterinariaIntegrador.dto.EspeciesDTO;
import com.huellitasChalacas.VeterinariaIntegrador.model.Especies;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author jtorr
 */
@Mapper(componentModel = "spring")
public interface EspeciesMapper {

    // Mapeo de Especies a EspeciesDTO
    EspeciesDTO toDTO(Especies especies);

    // Mapeo de EspeciesDTO  a Especies
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "mascotas", ignore = true)
    Especies toEntity(EspeciesDTO especiesDTO);

    // Método para mapear listas de Especies a listas de EspeciesDTO
    @IterableMapping(elementTargetType = EspeciesDTO.class)
    List<EspeciesDTO> toDtoList(List<Especies> especies);
}
