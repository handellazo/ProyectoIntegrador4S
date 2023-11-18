package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.CursoSemestreDto;
import pe.edu.upeu.proyInt.entity.*;
import pe.edu.upeu.proyInt.repository.*;
import pe.edu.upeu.proyInt.service.CursoSemestreService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class CursoSemestreServiceImpl implements CursoSemestreService {

    @Autowired
    private CursoSemestreInterface cursosemestreInterface;
    @Autowired
    private CursoInterface cursoInterface;
    @Autowired
    private SemestreInterface semestreInterface;
    @Autowired
    private DocenteInterface docenteInterface;
    @Autowired
    private EpInterface epInterface;
    @Override
    public List<CursoSemestreEntity> cursoSemestreListar() {
        return cursosemestreInterface.findAll();
    }

    @Override
    public CursoSemestreEntity buscarCursoSemestrePorId(int id) {
        return cursosemestreInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public CursoSemestreEntity guardarCursoSemestre(CursoSemestreDto cursoSemestreDto) {
        CursoEntity cursoEncontrado = cursoInterface.findById(cursoSemestreDto.getCurso()).orElse(null);
        SemestreEntity semestreEncontrado = semestreInterface.findById(cursoSemestreDto.getSemestre()).orElse(null);
        DocenteEntity docenteEncontrado = docenteInterface.findById(cursoSemestreDto.getDocente()).orElse(null);
        EpEntity epEncontrado = epInterface.findById(cursoSemestreDto.getEp()).orElse(null);

        CursoSemestreEntity nuevoCursoSemestre = new CursoSemestreEntity();
        nuevoCursoSemestre.setCurso(cursoEncontrado);
        nuevoCursoSemestre.setSemestre(semestreEncontrado);
        nuevoCursoSemestre.setDocente(docenteEncontrado);
        nuevoCursoSemestre.setEp(epEncontrado);

        return cursosemestreInterface.save(nuevoCursoSemestre);
    }

    @Override
    public CursoSemestreEntity editarCursoSemestre(int id, CursoSemestreDto cursoSemestreDto) {
        CursoSemestreEntity cursoSemestreEncontrado = cursosemestreInterface.findById(id).orElse(null);
        CursoEntity cursoEncontrado = cursoInterface.findById(cursoSemestreDto.getCurso()).orElse(null);
        SemestreEntity semestreEncontrado = semestreInterface.findById(cursoSemestreDto.getSemestre()).orElse(null);
        DocenteEntity docenteEncontrado = docenteInterface.findById(cursoSemestreDto.getDocente()).orElse(null);
        EpEntity epEncontrado = epInterface.findById(cursoSemestreDto.getEp()).orElse(null);

        if (cursoSemestreEncontrado != null){
            cursoSemestreEncontrado.setCurso(cursoEncontrado);
            cursoSemestreEncontrado.setSemestre(semestreEncontrado);
            cursoSemestreEncontrado.setEp(epEncontrado);
            cursoSemestreEncontrado.setDocente(docenteEncontrado);
            return cursosemestreInterface.save(cursoSemestreEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarCursoSemestre(int id) {
        cursosemestreInterface.deleteById(id);
    }
}