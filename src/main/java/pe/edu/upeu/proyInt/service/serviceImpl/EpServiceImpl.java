package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.entity.EpEntity;
import pe.edu.upeu.proyInt.repository.EpInterface;
import pe.edu.upeu.proyInt.service.EpService;

import java.util.List;

@Service
public class EpServiceImpl implements EpService {

    @Autowired
    private EpInterface epInterface;

    @Override
    public List<EpEntity> epListar() {
        return epInterface.findAll();
    }

    @Override
    public EpEntity guardarEp(EpEntity epEntity) {
        EpEntity nuevoEp = new EpEntity();
        nuevoEp.setNombre(epEntity.getNombre());
        nuevoEp.setFacultad(epEntity.getFacultad());
        return epInterface.save(nuevoEp);
    }

    @Override
    public EpEntity editarEp(int id, EpEntity epEntity) {
        EpEntity epEncontrado = epInterface.findById(id).orElse(null);
        if (epEntity != null){
            epEncontrado.setNombre(epEntity.getNombre());
            epEncontrado.setFacultad(epEntity.getFacultad());
            return epInterface.save(epEntity);
        }
        return null;
    }

    @Override
    public void eliminarEp(int id) {
        epInterface.deleteById(id);
    }
}