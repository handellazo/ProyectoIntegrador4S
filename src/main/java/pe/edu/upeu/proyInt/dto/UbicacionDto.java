package pe.edu.upeu.proyInt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UbicacionDto {

    private Integer id;

    private String distrito;

    private String provincia;

    private String departamento;
}
