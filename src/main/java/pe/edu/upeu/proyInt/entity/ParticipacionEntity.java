package pe.edu.upeu.proyInt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PARTICIPACION")
public class ParticipacionEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_PARTICIPACION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqParticipacion")
    @SequenceGenerator(sequenceName = "SEQ_PARTICIPACION", allocationSize = 1, name = "seqParticipacion")
    private Integer id;

    @Column(name = "URLINFORME")
    private Integer urlinforme;

    @Column(name = "PARTPORCEN")
    private Integer partporcen;

    @ManyToOne
    @JoinColumn(name = "MATRICULA_ID_MATRICULA")
    private MatriculaEntity matricula;

    @Column(name = "ASISTENCIA")
    private Integer asistencia;

    @Column(name = "ASISTENCIAVAL")
    private Integer asistenciaval;

    @Column(name = "NOTA")
    private Integer nota;

    @ManyToOne
    @JoinColumn(name = "GRUPOPY_ID_GRUPOPY")
    private GrupoPyEntity grupopy;

    @ManyToOne
    @JoinColumn(name = "ROLPY_ID_ROLPY")
    private RolPyEntity rolpy;

}
