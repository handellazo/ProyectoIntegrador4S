package pe.edu.upeu.proyInt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "SESION")
public class SesionEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_SESION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSesion")
    @SequenceGenerator(sequenceName = "SEQ_SESION", allocationSize = 1, name = "seqSesion")
    private Integer id;

    @Column(name = "fecha")
    private String fecha;

    @ManyToOne
    @JoinColumn(name = "PROYECTO_ID_PROYECTO")
    private ProyectoEntity proyecto;

}
