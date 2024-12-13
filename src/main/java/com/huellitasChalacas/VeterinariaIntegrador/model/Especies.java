package com.huellitasChalacas.VeterinariaIntegrador.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
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
//@Table(name = "especies")
public class Especies {

    @Id
    @Column(name = "id_especie", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEspecie;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    //CAMPOS DE AUDITORIA
    @Column(columnDefinition = "TIMESTAMP(3)", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(columnDefinition = "TIMESTAMP(3)")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    
    //CAMPOS RELACIONADOS
    @OneToMany(mappedBy = "especie", cascade = CascadeType.ALL)
    private List<Mascota> mascotas;

}
