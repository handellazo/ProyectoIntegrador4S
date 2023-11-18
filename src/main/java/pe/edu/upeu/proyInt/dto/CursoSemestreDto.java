package pe.edu.upeu.proyInt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CursoSemestreDto {

    private Integer id;

    private Integer curso; //FK

    private Integer semestre; //FK

    private Integer docente; //FK

    private Integer ep; //FK
}
