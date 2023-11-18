package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.EstudianteDto;
import pe.edu.upeu.proyInt.entity.*;
import pe.edu.upeu.proyInt.repository.*;
import pe.edu.upeu.proyInt.service.EstudianteService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteInterface estudianteInterface;
    @Autowired
    private PersonaInterface personaInterface;
    @Autowired
    private EpInterface epInterface;

    @Override
    public List<EstudianteEntity> estudianteListar() {
        return estudianteInterface.findAll();
    }

    @Override
    public EstudianteEntity buscarEstudiantePorId(int id) {
        return estudianteInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public EstudianteEntity guardarEstudiante(EstudianteDto estudianteDto) {
        PersonaEntity personaEncontrado = personaInterface.findById(estudianteDto.getPersona()).orElse(null);
        EpEntity epEncontrado = epInterface.findById(estudianteDto.getEp()).orElse(null);

        EstudianteEntity nuevoEstudiante = new EstudianteEntity();
        nuevoEstudiante.setCodigo(estudianteDto.getCodigo());
        nuevoEstudiante.setPersona(personaEncontrado);
        nuevoEstudiante.setEp(epEncontrado);
        return estudianteInterface.save(nuevoEstudiante);
    }

    @Override
    public EstudianteEntity editarEstudiante(int id, EstudianteDto estudianteDto) {
        EstudianteEntity estudianteEncontrado = estudianteInterface.findById(id).orElse(null);
        PersonaEntity personaEncontrado = personaInterface.findById(estudianteDto.getPersona()).orElse(null);
        EpEntity epEncontrado = epInterface.findById(estudianteDto.getEp()).orElse(null);

        if (estudianteEncontrado != null){
            estudianteEncontrado.setCodigo(estudianteDto.getCodigo());
            estudianteEncontrado.setPersona(personaEncontrado);
            estudianteEncontrado.setEp(epEncontrado);
            return estudianteInterface.save(estudianteEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarEstudiante(int id) {
        estudianteInterface.deleteById(id);
    }
}