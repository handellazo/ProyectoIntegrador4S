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
@Table(name = "GRUPOPY")
public class GrupoPyEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_GRUPOPY")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGrupoPy")
    @SequenceGenerator(sequenceName = "SEQ_GRUPOPY", allocationSize = 1, name = "seqGrupoPy")
    private Integer id;

    @Column(name="NOMBRE")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "PROYECTO_ID_PROYECTO")
    private ProyectoEntity proyecto;

    @ManyToOne
    @JoinColumn(name = "SESION_ID_SESION")
    private SesionEntity sesion;
}
