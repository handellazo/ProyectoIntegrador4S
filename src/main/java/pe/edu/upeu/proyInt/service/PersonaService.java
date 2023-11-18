package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.PersonaDto;
import pe.edu.upeu.proyInt.entity.PersonaEntity;

import java.util.List;

public interface PersonaService {
    //Clases generadas para la funcionalidad de las APIS
    List<PersonaEntity> personaListar();
    PersonaEntity buscarPersonaPorId(int id);
    PersonaEntity guardarPersona(PersonaDto personaDto);
    PersonaEntity editarPersona(int id, PersonaDto personaDto);
    void eliminarPersona(int id);
}
