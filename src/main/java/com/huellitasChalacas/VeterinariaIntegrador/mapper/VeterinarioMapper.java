/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.mapper;

import com.huellitasChalacas.VeterinariaIntegrador.dto.VeterinarioDTO;
import com.huellitasChalacas.VeterinariaIntegrador.model.Veterinario;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 *
 * @author jtorr
 */
@Mapper(componentModel = "spring", uses = {TipoDocMapper.class, EspecialidadMapper.class})
public interface VeterinarioMapper {

    // Mapeo de Veterinario a VeterianrioDTO
    @Mapping(target = "tipoDocDTO", source = "tipoDoc")
    @Mapping(target = "especialidadDTO", source = "especialidad")
    VeterinarioDTO toDTO(Veterinario veterinario);

    // Mapeo de TipoDocDTO  a TipoDoc
    @Mapping(target = "tipoDoc", source = "tipoDocDTO")
    @Mapping(target = "especialidad", source = "especialidadDTO")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "usuarios", ignore = true)
    @Mapping(target = "citas", ignore = true)
    Veterinario toEntity(VeterinarioDTO veterinarioDTO);

    // Método para mapear listas de Veterinario a listas de VeterinarioDTO 
    @IterableMapping(elementTargetType = VeterinarioDTO.class)
    List<VeterinarioDTO> toDtoList(List<Veterinario> veterinario);
}
