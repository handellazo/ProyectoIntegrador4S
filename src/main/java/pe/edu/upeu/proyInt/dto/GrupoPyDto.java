package pe.edu.upeu.proyInt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GrupoPyDto {

    private Integer id;

    private String nombre;

    private Integer proyecto; //FK

    private Integer sesion; //FK
}
