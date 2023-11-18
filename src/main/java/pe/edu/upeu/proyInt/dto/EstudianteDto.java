package pe.edu.upeu.proyInt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EstudianteDto {

    private Integer id;

    private String codigo;

    private Integer persona; //FK

    private Integer ep; //FK
}
