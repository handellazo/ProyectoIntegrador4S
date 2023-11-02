package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.entity.CursoSemestreEntity;
import pe.edu.upeu.proyInt.repository.CursoSemestreInterface;
import pe.edu.upeu.proyInt.service.CursoSemestreService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class CursoSemestreServiceImpl implements CursoSemestreService {

    @Autowired
    private CursoSemestreInterface cursosemestreInterface;

    @Override
    public List<CursoSemestreEntity> cursoSemestreListar() {
        return cursosemestreInterface.findAll();
    }

    @Override
    public CursoSemestreEntity guardarCursoSemestre(CursoSemestreEntity cursoSemestreEntity) {
        CursoSemestreEntity nuevoCursoSemestre = new CursoSemestreEntity();
        nuevoCursoSemestre.setCurso(nuevoCursoSemestre.getCurso());
        nuevoCursoSemestre.setSemestre(nuevoCursoSemestre.getSemestre());
        nuevoCursoSemestre.setEp(nuevoCursoSemestre.getEp());
        nuevoCursoSemestre.setDocente(nuevoCursoSemestre.getDocente());
        return cursosemestreInterface.save(nuevoCursoSemestre);
    }

    @Override
    public CursoSemestreEntity editarCursoSemestre(int id, CursoSemestreEntity cursoSemestreEntity) {
        CursoSemestreEntity cursoSemestreEncontrado = cursosemestreInterface.findById(id).orElse(null);
        if (cursoSemestreEncontrado != null){
            cursoSemestreEncontrado.setCurso(cursoSemestreEntity.getCurso());
            cursoSemestreEncontrado.setSemestre(cursoSemestreEntity.getSemestre());
            cursoSemestreEncontrado.setEp(cursoSemestreEntity.getEp());
            cursoSemestreEncontrado.setDocente(cursoSemestreEntity.getDocente());
            return cursosemestreInterface.save(cursoSemestreEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarCursoSemestre(int id) {
        cursosemestreInterface.deleteById(id);
    }
}