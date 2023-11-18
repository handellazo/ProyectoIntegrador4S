package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.SemestreDto;
import pe.edu.upeu.proyInt.entity.SemestreEntity;
import pe.edu.upeu.proyInt.repository.SemestreInterface;
import pe.edu.upeu.proyInt.service.SemestreService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class SemestreServiceImpl implements SemestreService {

    @Autowired
    private SemestreInterface semestreInterface;

    @Override
    public List<SemestreEntity> semestreListar() {
        return semestreInterface.findAll();
    }

    @Override
    public SemestreEntity buscarSemestrePorId(int id) {
        return semestreInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public SemestreEntity guardarSemestre(SemestreDto semestreDto) {
        SemestreEntity nuevoSemestre = new SemestreEntity();
        nuevoSemestre.setSemestre(semestreDto.getSemestre());
        return semestreInterface.save(nuevoSemestre);
    }

    @Override
    public SemestreEntity editarSemestre(int id, SemestreDto semestreDto) {
        SemestreEntity semestreEncontrado = semestreInterface.findById(id).orElse(null);
        if (semestreEncontrado != null){
            semestreEncontrado.setSemestre(semestreDto.getSemestre());
            return semestreInterface.save(semestreEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarSemestre(int id) {
        semestreInterface.deleteById(id);
    }
}