package com.huellitasChalacas.VeterinariaIntegrador.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Servicio extends Articulo {

    @Column(name = "Duracion", nullable = false)
    private Integer duracion;

    //CAMPOS RELACIONADOS
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipoServicio")
    private TipoServicio tipoServicio;

}
