package pe.edu.upeu.proyInt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "UBICACION")
public class UbicacionEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_UBICACION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUbicacion")
    @SequenceGenerator(sequenceName = "SEQ_UBICACION", allocationSize = 1, name = "seqUbicacion")
    private Integer id;

    @Column(name = "DISTRITO")
    private String distrito;

    @Column(name = "PROVINCIA")
    private String provincia;

    @Column(name = "DEPARTAMENTO")
    private String departamento;

}
