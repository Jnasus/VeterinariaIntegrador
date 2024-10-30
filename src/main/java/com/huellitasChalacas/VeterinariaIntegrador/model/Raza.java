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
@Table(name = "raza")
public class Raza {

    @Id
    @Column(name = "id_raza", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRaza;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @OneToMany(mappedBy = "raza", cascade = CascadeType.ALL)
    private List<Mascota> mascotas;

}
