package com.huellitasChalacas.VeterinariaIntegrador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Mascota {

    @Id
    @Column(name = "id_mascota", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMascota;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column
    private String aPaterno;

    @Column
    private String aMaterno;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column
    private LocalDate fechNacimiento;

    @Column(name = "sexo")
    private String sexo;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_especie", nullable = false)
    private Especies especie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_raza", nullable = false)
    private Raza raza;

    @OneToOne(mappedBy = "mascota", cascade = CascadeType.ALL)
    private Historia historia;

    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

}
