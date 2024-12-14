/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.mapper;

import com.huellitasChalacas.VeterinariaIntegrador.dto.CitasDTO;
import com.huellitasChalacas.VeterinariaIntegrador.model.Citas;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author jtorr
 */
@Mapper(componentModel = "spring", uses = VeterinarioMapper.class)
public interface CitasMapper {

    @Mapping(target = "veterinarioDTO", source = "veterinario")
    CitasDTO toDto(Citas citas);

    @Mapping(target = "veterinario", source = "veterinarioDTO")
    @Mapping(target = "reservas", ignore = true)
    Citas toEntity(CitasDTO citasDTO);

    @IterableMapping(elementTargetType = CitasDTO.class)
    List<CitasDTO> toDtoList(List<Citas> citas);

}
