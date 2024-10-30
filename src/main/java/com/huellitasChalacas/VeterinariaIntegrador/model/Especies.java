package com.huellitasChalacas.VeterinariaIntegrador.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "especies")
public class Especies {

    @Id
    @Column(name = "id_especie", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEspecie;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @OneToMany(mappedBy = "especie", cascade = CascadeType.ALL)
    private List<Mascota> mascotas;

}
