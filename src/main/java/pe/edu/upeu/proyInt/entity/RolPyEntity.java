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
@Table(name = "ROLPY")
public class RolPyEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_ROLPY")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRolPy")
    @SequenceGenerator(sequenceName = "SEQ_ROLPY", allocationSize = 1, name = "seqRolPy")
    private Integer id;

    @Column(name="HORAS")
    private String horas;

    @ManyToOne
    @JoinColumn(name = "ROLEST_ID_ROLEST")
    private RolEstudianteEntity rolEst;

    @ManyToOne
    @JoinColumn(name = "PROYECTO_ID_PROYECTO")
    private ProyectoEntity proyecto;

}
