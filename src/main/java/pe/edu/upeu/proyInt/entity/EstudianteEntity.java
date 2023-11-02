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
@Table(name = "ESTUDIANTE")
public class EstudianteEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_ESTUDIANTE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEstudiante")
    @SequenceGenerator(sequenceName = "SEQ_ESTUDIANTE", allocationSize = 1, name = "seqEstudiante")
    private Integer id;

    @Column(name = "CODIGO")
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "PERSONA_ID_PERSONA")
    private PersonaEntity persona;

    @ManyToOne
    @JoinColumn(name = "EP_ID_EP")
    private EpEntity ep;

}
