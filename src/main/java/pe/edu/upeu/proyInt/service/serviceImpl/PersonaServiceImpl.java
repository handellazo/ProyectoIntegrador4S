package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.PersonaDto;
import pe.edu.upeu.proyInt.entity.PersonaEntity;
import pe.edu.upeu.proyInt.entity.RolEntity;
import pe.edu.upeu.proyInt.repository.PersonaInterface;
import pe.edu.upeu.proyInt.repository.RolInterface;
import pe.edu.upeu.proyInt.service.PersonaService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;
@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaInterface personaInterface;
    @Autowired
    private RolInterface rolInterface;

    @Override
    public List<PersonaEntity> personaListar() {
        return personaInterface.findAll();
    }

    @Override
    public PersonaEntity buscarPersonaPorId(int id) {
        return personaInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public PersonaEntity guardarPersona(PersonaDto personaDto) {
        RolEntity rolEncontrado = rolInterface.findById(personaDto.getRol()).orElse(null);

        PersonaEntity nuevoPersona = new PersonaEntity();
        nuevoPersona.setNombre(personaDto.getNombre());
        nuevoPersona.setPaterno(personaDto.getPaterno());
        nuevoPersona.setMaterno(personaDto.getMaterno());
        nuevoPersona.setDni(personaDto.getDni());
        nuevoPersona.setCorreo(personaDto.getCorreo());
        nuevoPersona.setTelefono(personaDto.getTelefono());
        nuevoPersona.setRol(rolEncontrado);
        return personaInterface.save(nuevoPersona);
    }

    @Override
    public PersonaEntity editarPersona(int id, PersonaDto personaDto) {
        PersonaEntity personaEncontrado = personaInterface.findById(id).orElse(null);
        RolEntity rolEncontrado = rolInterface.findById(personaDto.getRol()).orElse(null);

        if (personaEncontrado != null){
            personaEncontrado.setNombre(personaDto.getNombre());
            personaEncontrado.setPaterno(personaDto.getPaterno());
            personaEncontrado.setMaterno(personaDto.getMaterno());
            personaEncontrado.setDni(personaDto.getDni());
            personaEncontrado.setCorreo(personaDto.getCorreo());
            personaEncontrado.setTelefono(personaDto.getTelefono());
            personaEncontrado.setRol(rolEncontrado);
            return personaInterface.save(personaEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarPersona(int id) {
        personaInterface.deleteById(id);
    }
}