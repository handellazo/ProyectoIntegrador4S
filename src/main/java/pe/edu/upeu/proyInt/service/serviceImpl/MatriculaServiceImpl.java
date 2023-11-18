package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.MatriculaDto;
import pe.edu.upeu.proyInt.entity.*;
import pe.edu.upeu.proyInt.repository.*;
import pe.edu.upeu.proyInt.service.MatriculaService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    private MatriculaInterface matriculaInterface;
    @Autowired
    private EstudianteInterface estudianteInterface;
    @Autowired
    private CursoSemestreInterface cursoSemestreInterface;

    @Override
    public List<MatriculaEntity> matriculaListar() {
        return matriculaInterface.findAll();
    }

    @Override
    public MatriculaEntity buscarMatriculaPorId(int id) {
        return matriculaInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public MatriculaEntity guardarMatricula(MatriculaDto matriculaDto) {
        EstudianteEntity estudianteEncontrado = estudianteInterface.findById(matriculaDto.getEstudiante()).orElse(null);
        CursoSemestreEntity cursoSemestreEncontrado = cursoSemestreInterface.findById(matriculaDto.getCursoSemestre()).orElse(null);

        MatriculaEntity nuevoMatricula = new MatriculaEntity();
        nuevoMatricula.setEstudiante(estudianteEncontrado);
        nuevoMatricula.setCursoSemestre(cursoSemestreEncontrado);
        nuevoMatricula.setCiclo(matriculaDto.getCiclo());
        return matriculaInterface.save(nuevoMatricula);
    }

    @Override
    public MatriculaEntity editarMatricula(int id, MatriculaDto matriculaDto) {
        MatriculaEntity matriculaEncontrado = matriculaInterface.findById(id).orElse(null);
        EstudianteEntity estudianteEncontrado = estudianteInterface.findById(matriculaDto.getEstudiante()).orElse(null);
        CursoSemestreEntity cursoSemestreEncontrado = cursoSemestreInterface.findById(matriculaDto.getCursoSemestre()).orElse(null);

        if (matriculaEncontrado != null){
            matriculaEncontrado.setEstudiante(estudianteEncontrado);
            matriculaEncontrado.setCursoSemestre(cursoSemestreEncontrado);
            matriculaEncontrado.setCiclo(matriculaDto.getCiclo());
            return matriculaInterface.save(matriculaEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarMatricula(int id) {
        matriculaInterface.deleteById(id);
    }
}