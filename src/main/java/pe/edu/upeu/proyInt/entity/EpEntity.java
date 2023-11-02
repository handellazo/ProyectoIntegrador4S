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
@Table(name = "EP")
public class EpEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_EP")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEp")
    @SequenceGenerator(sequenceName = "SEQ_EP", allocationSize = 1, name = "seqEp")
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "FACULTAD_ID_FACULTAD")
    private FacultadEntity facultad;

}
