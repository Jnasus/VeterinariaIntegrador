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
public class TipoDoc {

    @Id
    @Column(name = "id_tipoDoc", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoDoc;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "tipoDoc", cascade = CascadeType.ALL)
    //@JsonManagedReference // mantiene la refencia en serializacions
    private List<Persona> personas;
}
