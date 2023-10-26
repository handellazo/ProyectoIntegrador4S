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
@Table(name = "DOCENTE")
public class DocenteEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_DOCENTE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqDocente")
    @SequenceGenerator(sequenceName = "SEQ_DOCENTE", allocationSize = 1, name = "seqDocente")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID_PERSONA")
    private PersonaEntity persona;

    @ManyToOne
    @JoinColumn(name = "EP_ID_EP")
    private EpEntity ep;

    @ManyToOne
    @JoinColumn(name = "ROLDOC_ID_ROLDOC")
    private EpEntity rolDocente;

}
