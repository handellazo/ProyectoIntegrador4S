package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.entity.EstudianteEntity;
import pe.edu.upeu.proyInt.repository.EstudianteInterface;
import pe.edu.upeu.proyInt.service.EstudianteService;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteInterface estudianteInterface;

    @Override
    public List<EstudianteEntity> estudianteListar() {
        return estudianteInterface.findAll();
    }

    @Override
    public EstudianteEntity guardarEstudiante(EstudianteEntity estudianteEntity) {
        EstudianteEntity nuevoEstudiante = new EstudianteEntity();
        nuevoEstudiante.setCodigo(estudianteEntity.getCodigo());
        nuevoEstudiante.setPersona(estudianteEntity.getPersona());
        nuevoEstudiante.setEp(estudianteEntity.getEp());
        return estudianteInterface.save(nuevoEstudiante);
    }

    @Override
    public EstudianteEntity editarEstudiante(int id, EstudianteEntity estudianteEntity) {
        EstudianteEntity estudianteEncontrado = estudianteInterface.findById(id).orElse(null);
        if (estudianteEntity != null){
            estudianteEncontrado.setCodigo(estudianteEntity.getCodigo());
            estudianteEncontrado.setPersona(estudianteEntity.getPersona());
            estudianteEncontrado.setEp(estudianteEntity.getEp());
            return estudianteInterface.save(estudianteEntity);
        }
        return null;
    }

    @Override
    public void eliminarEstudiante(int id) {
        estudianteInterface.deleteById(id);
    }
}