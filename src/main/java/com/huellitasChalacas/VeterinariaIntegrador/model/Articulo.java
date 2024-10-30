package com.huellitasChalacas.VeterinariaIntegrador.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED) // Utilizando una tabla separada para cada clase hijaS
@Table(name = "articulos")
public class Articulo {

    @Id
    @Column(name = "id_articulo", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArticulo;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "precio_venta", nullable = false)
    private BigDecimal precioVenta;

    @Column(name = "descripcion")
    private String descripcion;
    
    @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL )
    private List<FacturaDetalle> facturaDetalle;
    
    
}
