package pe.edu.upeu.proyInt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ROL")
public class RolEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "ID_ROL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRol")
    @SequenceGenerator(sequenceName = "SEQ_ROL", allocationSize = 1, name = "seqRol")
    private Integer id;

    @Column(name="ROL")
    private String rol;

    @OneToMany(mappedBy = "rol", fetch = FetchType.EAGER)
    private Set<PersonaEntity> personaEntity;

}
