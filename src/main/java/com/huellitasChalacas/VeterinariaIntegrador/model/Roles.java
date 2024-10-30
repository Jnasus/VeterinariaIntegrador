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
@Table(name = "roles")
public class Roles {

    @Id
    @Column(name = "id_rol", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;

}
