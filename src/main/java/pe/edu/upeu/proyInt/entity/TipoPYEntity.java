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
@Table(name = "TIPOPY")
public class TipoPYEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_TIPOPY")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTipoPy")
    @SequenceGenerator(sequenceName = "SEQ_TIPOPY", allocationSize = 1, name = "seqTipoPy")
    private Integer id;

    @Column(name = "TIPOPY")
    private String tipoPy;

}
