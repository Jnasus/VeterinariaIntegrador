package com.huellitasChalacas.VeterinariaIntegrador.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Servicio extends Articulo {

//    @Id
//    @Column(name = "id_servicios", nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer idServicios;
    @Column(name = "Duracion", nullable = false)
    private Integer duracion;

//    @Column(name = "id_tipoServicio")
//    private Integer idTiposervicio;
    
    //cardinalidad
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipoServicio")
    @JsonBackReference // Evita serialización infinita
    private TipoServicio tipoServicio;

}
