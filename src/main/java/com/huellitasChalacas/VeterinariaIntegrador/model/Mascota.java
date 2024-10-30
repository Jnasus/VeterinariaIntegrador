package com.huellitasChalacas.VeterinariaIntegrador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mascota")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Cliente")
    @JsonIgnore
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_especie")
    @JsonIgnore
    private Especies especie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_raza")
    @JsonIgnore
    private Raza raza;

    //@Column(name = "fech_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechNacimiento;

    @Column(name = "sexo")
    private String sexo;

    @OneToOne(mappedBy = "mascota", cascade = CascadeType.ALL)
    private Historia historia;

    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

}
