package com.huellitasChalacas.VeterinariaIntegrador.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "factura_maestro")
public class FacturaMaestro {

    @Id
    @Column(name = "id_factura", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFactura;

    @Temporal(TemporalType.DATE)
    private Date fecha;

//    @Column(name = "id_cliente")
//    private Integer idCliente;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "impuesto_total")
    private BigDecimal impuestoTotal;

    @Column(name = "descuento_total")
    private BigDecimal descuentoTotal;

    @Column(name = "total_compra")
    private BigDecimal totalCompra;

    @Column(name = "observaciones")
    private String observaciones;
    
    // Relación uno a muchos con FacturaDetalle
    @OneToMany(mappedBy = "facturaMaestro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FacturaDetalle> detalles;

}
