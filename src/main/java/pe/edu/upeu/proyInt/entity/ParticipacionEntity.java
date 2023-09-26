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

    @Column(name = "CICLO")
    private Integer ciclo;

    @Column(name = "AÑO")
    private Integer año;

    @Column(name = "CANT_HORAS")
    private Integer horas;

    @Column(name = "ESTADO_PART")
    private Integer estadoPart;

    /*@Column(name = "PROYECTO_ID_PROYECTO")
    private Integer proyectoIdProyecto;

    @Column(name = "PERSONA_ID_PERSONA")
    private Integer personaIdPersona;*/

}
