/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.mapper;

import com.huellitasChalacas.VeterinariaIntegrador.dto.TipoDocDTO;
import com.huellitasChalacas.VeterinariaIntegrador.model.TipoDoc;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author jtorr
 */
@Mapper(componentModel = "spring")
public interface TipoDocMapper {

    //TipoDocMapper INSTANCE = Mappers.getMapper(TipoDocMapper.class);
    // Mapeo de TipoDoc a TipoDocDTO
    TipoDocDTO toDTO(TipoDoc tipoDoc);

    // Mapeo de TipoDocDTO  a TipoDoc
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "personas", ignore = true)
    TipoDoc toEntity(TipoDocDTO tipoDocDTO);

    // Método para mapear listas de TipoDoc a listas de TipoDocDTO
    @IterableMapping(elementTargetType = TipoDocDTO.class)
    List<TipoDocDTO> toDtoList(List<TipoDoc> tipoDocs);

}
