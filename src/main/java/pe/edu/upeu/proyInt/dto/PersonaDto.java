package pe.edu.upeu.proyInt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonaDto {

    private Integer id;

    private String nombre;

    private String paterno;

    private String materno;

    private Integer dni;

    private String correo;

    private Integer telefono;

    private Integer rol; //FK
}
