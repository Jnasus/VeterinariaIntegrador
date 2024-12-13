/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huellitasChalacas.VeterinariaIntegrador.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jtorr
 */
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private Integer idArticulo;
    private String nombre;
    private BigDecimal precioVenta;
    private String descripcion;
    private BigDecimal precioCosto;
    private Integer stock;
    //DTOS ANIDADOS
    private CategoriaProductoDTO categoriaProductoDTO;
}
