/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.mapper;

import com.huellitasChalacas.VeterinariaIntegrador.dto.ClienteDTO;
import com.huellitasChalacas.VeterinariaIntegrador.model.Cliente;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author jtorr
 */
@Mapper(componentModel = "spring", uses = TipoDocMapper.class)
public interface ClienteMapper {

    //ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mapping(target = "tipoDocDTO", source = "tipoDoc")
    ClienteDTO toDTO(Cliente cliente);

    @Mapping(target = "tipoDoc", source = "tipoDocDTO")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "usuarios", ignore = true)
    @Mapping(target = "mascotas", ignore = true)
    @Mapping(target = "facturasMaestro", ignore = true)
    Cliente toEntity(ClienteDTO clienteDTO);
    
    // Método para mapear listas de clientes a listas de DTOs
    @IterableMapping(elementTargetType = ClienteDTO.class)
    List<ClienteDTO> toDtoList(List<Cliente> clientes);
}
