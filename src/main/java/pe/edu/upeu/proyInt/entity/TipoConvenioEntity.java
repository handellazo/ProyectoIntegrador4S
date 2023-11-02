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
@Table(name = "TIPOCONVENIO")
public class TipoConvenioEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_TIPOCONVENIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTipoConvenio")
    @SequenceGenerator(sequenceName = "SEQ_TIPOCONVENIO", allocationSize = 1, name = "seqTipoConvenio")
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

}
