package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.CursoDto;
import pe.edu.upeu.proyInt.entity.CursoEntity;
import pe.edu.upeu.proyInt.repository.CursoInterface;
import pe.edu.upeu.proyInt.service.CursoService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoInterface cursoInterface;

    @Override
    public List<CursoEntity> cursoListar() {
        return cursoInterface.findAll();
    }

    @Override
    public CursoEntity buscarCursoPorId(int id) {
        return cursoInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public CursoEntity guardarCurso(CursoDto cursoDto) {
        CursoEntity nuevoCurso = new CursoEntity();
        nuevoCurso.setNombre(cursoDto.getNombre());
        return cursoInterface.save(nuevoCurso);
    }

    @Override
    public CursoEntity editarCurso(int id, CursoDto cursoDto) {
        CursoEntity cursoEncontrado = cursoInterface.findById(id).orElse(null);
        if (cursoEncontrado != null){
            cursoEncontrado.setNombre(cursoDto.getNombre());
            return cursoInterface.save(cursoEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarCurso(int id) {
        cursoInterface.deleteById(id);
    }
}