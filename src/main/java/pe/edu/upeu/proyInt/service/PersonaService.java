package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.PersonaEntity;

import java.util.List;

public interface PersonaService {
    //Clases generadas para la funcionalidad de las APIS
    List<PersonaEntity> personaListar();
    PersonaEntity buscarPersonaPorID(int id);
    PersonaEntity guardarPersona(PersonaEntity personaEntity);
    PersonaEntity editarPersona(int id, PersonaEntity personaEntity);
    void eliminarPersona(int id);
}
