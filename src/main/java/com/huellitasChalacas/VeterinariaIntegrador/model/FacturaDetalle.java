package com.huellitasChalacas.VeterinariaIntegrador.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "factura_detalle")
public class FacturaDetalle {
    
    @EmbeddedId
    private FacturaDetalleId id;  
    
    @ManyToOne
    @MapsId("idFactura") // Hace referencia a la clave de FacturaMaestro
    @JoinColumn(name = "id_factura")
    private FacturaMaestro facturaMaestro;
    
    @ManyToOne
    @MapsId("idArticulo") // Hace referencia a la clave de Articulo
    @JoinColumn(name = "id_articulo")
    private Articulo articulo;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;

    @Column(name = "impuesto")
    private BigDecimal impuesto;

    @Column(name = "descuento")
    private BigDecimal descuento;

    @Column(name = "total_lineal")
    private BigDecimal totalLineal;

}
