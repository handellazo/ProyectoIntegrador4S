package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.entity.MatriculaEntity;
import pe.edu.upeu.proyInt.repository.MatriculaInterface;
import pe.edu.upeu.proyInt.service.MatriculaService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaInterface matriculaInterface;

    @Override
    public List<MatriculaEntity> matriculaListar() {
        return matriculaInterface.findAll();
    }

    @Override
    public MatriculaEntity guardarMatricula(MatriculaEntity matriculaEntity) {
        MatriculaEntity nuevoMatricula = new MatriculaEntity();
        nuevoMatricula.setEstudiante(matriculaEntity.getEstudiante());
        nuevoMatricula.setCurso(matriculaEntity.getCurso());
        nuevoMatricula.setCiclo(matriculaEntity.getCiclo());
        return matriculaInterface.save(nuevoMatricula);
    }

    @Override
    public MatriculaEntity editarMatricula(int id, MatriculaEntity matriculaEntity) {
        MatriculaEntity matriculaEncontrado = matriculaInterface.findById(id).orElse(null);
        if (matriculaEncontrado != null){
            matriculaEncontrado.setEstudiante(matriculaEntity.getEstudiante());
            matriculaEncontrado.setCurso(matriculaEntity.getCurso());
            matriculaEncontrado.setCiclo(matriculaEntity.getCiclo());
            return matriculaInterface.save(matriculaEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarMatricula(int id) {
        matriculaInterface.deleteById(id);
    }
}