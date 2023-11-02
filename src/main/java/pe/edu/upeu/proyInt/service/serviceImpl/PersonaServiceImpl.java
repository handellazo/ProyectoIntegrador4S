package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.entity.PersonaEntity;
import pe.edu.upeu.proyInt.repository.PersonaInterface;
import pe.edu.upeu.proyInt.service.PersonaService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;
@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaInterface personaInterface;

    @Override
    public List<PersonaEntity> personaListar() {
        return personaInterface.findAll();
    }

    @Override
    public PersonaEntity buscarPersonaPorID(int id) {
        return personaInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public PersonaEntity guardarPersona(PersonaEntity personaEntity) {
        PersonaEntity nuevoPersona = new PersonaEntity();
        nuevoPersona.setNombre(personaEntity.getNombre());
        nuevoPersona.setPaterno(personaEntity.getPaterno());
        nuevoPersona.setMaterno(personaEntity.getMaterno());
        nuevoPersona.setDni(personaEntity.getDni());
        nuevoPersona.setCorreo(personaEntity.getCorreo());
        nuevoPersona.setTelefono(personaEntity.getTelefono());
        return personaInterface.save(nuevoPersona);
    }

    @Override
    public PersonaEntity editarPersona(int id, PersonaEntity personaEntity) {
        PersonaEntity personaEncontrado = personaInterface.findById(id).orElse(null);
        if (personaEncontrado != null){
            personaEncontrado.setNombre(personaEntity.getNombre());
            personaEncontrado.setPaterno(personaEntity.getPaterno());
            personaEncontrado.setMaterno(personaEntity.getMaterno());
            personaEncontrado.setDni(personaEntity.getDni());
            personaEncontrado.setCorreo(personaEntity.getCorreo());
            personaEncontrado.setTelefono(personaEntity.getTelefono());
            return personaInterface.save(personaEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarPersona(int id) {
        personaInterface.deleteById(id);
    }
}