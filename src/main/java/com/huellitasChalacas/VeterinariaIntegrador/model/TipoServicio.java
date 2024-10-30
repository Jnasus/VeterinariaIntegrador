package com.huellitasChalacas.VeterinariaIntegrador.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TipoServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_servicio", nullable = false)
    private Integer idTipoServicio;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    //cardinalidad
    @OneToMany(mappedBy = "tipoServicio")
    @JsonManagedReference // Mantiene la referencia en serialización
    private List<Servicio> servicios;
}
