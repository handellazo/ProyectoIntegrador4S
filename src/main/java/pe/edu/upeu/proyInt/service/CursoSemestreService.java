package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.CursoSemestreDto;
import pe.edu.upeu.proyInt.entity.ConvenioEntity;
import pe.edu.upeu.proyInt.entity.CursoSemestreEntity;

import java.util.List;

public interface CursoSemestreService {
    List<CursoSemestreEntity> cursoSemestreListar();
    CursoSemestreEntity buscarCursoSemestrePorId(int id);
    CursoSemestreEntity guardarCursoSemestre(CursoSemestreDto cursoSemestreDto);
    CursoSemestreEntity editarCursoSemestre(int id, CursoSemestreDto cursoSemestreDto);
    void eliminarCursoSemestre(int id);
}
