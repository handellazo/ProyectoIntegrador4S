package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.entity.SemestreEntity;
import pe.edu.upeu.proyInt.repository.SemestreInterface;
import pe.edu.upeu.proyInt.service.SemestreService;

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
    public SemestreEntity guardarSemestre(SemestreEntity semestreEntity) {
        SemestreEntity nuevoSemestre = new SemestreEntity();
        nuevoSemestre.setSemestre(semestreEntity.getSemestre());
        return semestreInterface.save(nuevoSemestre);
    }

    @Override
    public SemestreEntity editarSemestre(int id, SemestreEntity semestreEntity) {
        SemestreEntity semestreEncontrado = semestreInterface.findById(id).orElse(null);
        if (semestreEntity != null){
            semestreEntity.setSemestre(semestreEntity.getSemestre());
            return semestreInterface.save(semestreEntity);
        }
        return null;
    }

    @Override
    public void eliminarSemestre(int id) {
        semestreInterface.deleteById(id);
    }
}