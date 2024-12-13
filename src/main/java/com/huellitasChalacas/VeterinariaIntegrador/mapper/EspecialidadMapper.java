/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.mapper;

import com.huellitasChalacas.VeterinariaIntegrador.dto.EspecialidadDTO;
import com.huellitasChalacas.VeterinariaIntegrador.model.Especialidad;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author jtorr
 */
@Mapper(componentModel = "spring")
public interface EspecialidadMapper {

    //Mapeo de Especialidad a EspecialidadDTO
    EspecialidadDTO toDTO(Especialidad especialidad);

    //Mapeo de EspecialidadDTO a Especialidad
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "veterinarios", ignore = true)
    Especialidad toEntity(EspecialidadDTO especialidadDTO);

    //Metodo para mapear listas de tipo Especialidad a EspecialidadDTO
    @IterableMapping(elementTargetType = EspecialidadDTO.class)
    List<EspecialidadDTO> toDtoList(List<Especialidad> especialidades);

}
