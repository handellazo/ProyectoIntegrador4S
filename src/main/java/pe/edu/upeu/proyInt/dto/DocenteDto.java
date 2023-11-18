package pe.edu.upeu.proyInt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DocenteDto {

    private Integer id;

    private Integer persona; //FK

    private Integer ep; //FK
}
