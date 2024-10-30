package com.huellitasChalacas.VeterinariaIntegrador.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "persona")
public class Persona {

    @Id
    @Column(name = "id_persona", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;

    //@Column(name = "nombres")
    private String nombres;

    //@Column(name = "aPaterno")
    private String aPaterno;

    //@Column(name = "aMaterno")
    private String aMaterno;

    //@Column(name = "sexo")
    private String sexo;

    @Temporal(TemporalType.DATE)
    private Date fechNacimiento;

    //@Column(name = "direccion")
    private String direccion;

    //@Column(name = "celular")
    private String celular;

    //@Column(name = "correo")
    private String correo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipoDoc", nullable = false)
    //@JsonBackReference //evita serializacion infinita
    private TipoDoc tipoDoc;

    @Column(name = "doc_ID")
    private String docId;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    //@JsonManagedReference //mantiene la referencia en serializacion
    private List<Usuario> usuarios;

}
