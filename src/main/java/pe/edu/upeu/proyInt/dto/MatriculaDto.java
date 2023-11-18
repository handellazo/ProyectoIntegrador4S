package pe.edu.upeu.proyInt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MatriculaDto {

    private Integer id;

    private Integer estudiante; //FK

    private Integer cursoSemestre; //FK

    private Integer ciclo;
}
