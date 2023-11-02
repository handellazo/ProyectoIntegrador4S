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
@Table(name = "CONVENIO")
public class ConvenioEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_CONVENIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqConvenio")
    @SequenceGenerator(sequenceName = "SEQ_CONVENIO", allocationSize = 1, name = "seqConvenio")
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "FECHA_INICIO")
    private Date inicio;

    @Column(name = "FECHA_FIN")
    private Date fin;

    @Column(name = "REFERENCIA")
    private String referencia;

    @ManyToOne
    @JoinColumn(name = "TIPO_ID_TIPO")
    private TipoConvenioEntity tipo;

    @ManyToOne
    @JoinColumn(name = "UBICACION_ID_UBICACION")
    private UbicacionEntity ubicacion;

}