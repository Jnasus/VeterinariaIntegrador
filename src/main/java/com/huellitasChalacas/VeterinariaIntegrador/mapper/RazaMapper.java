/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.mapper;

import com.huellitasChalacas.VeterinariaIntegrador.dto.RazaDTO;
import com.huellitasChalacas.VeterinariaIntegrador.model.Raza;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author jtorr
 */
@Mapper(componentModel = "spring")
public interface RazaMapper {

    //TipoDocMapper INSTANCE = Mappers.getMapper(TipoDocMapper.class);
    // Mapeo de TipoDoc a TipoDocDTO
    RazaDTO toDTO(Raza raza);

    // Mapeo de TipoDocDTO  a TipoDoc
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "mascotas", ignore = true)
    Raza toEntity(RazaDTO razaDTO);

    // Método para mapear listas de TipoDoc a listas de TipoDocDTO
    @IterableMapping(elementTargetType = RazaDTO.class)
    List<RazaDTO> toDtoList(List<Raza> razas);
}
