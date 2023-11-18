package pe.edu.upeu.proyInt.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upeu.proyInt.entity.GrupoPyEntity;
import pe.edu.upeu.proyInt.entity.MatriculaEntity;
import pe.edu.upeu.proyInt.entity.RolPyEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ParticipacionDto {

    private Integer id;

    private Integer urlinforme;

    private Integer partporcen;

    private Integer matricula; //FK

    private Integer asistencia;

    private Integer asistenciaval;

    private Integer nota;

    private Integer grupopy; //FK

    private Integer rolpy; //FK
}
