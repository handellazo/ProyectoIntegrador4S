package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.entity.FacultadEntity;
import pe.edu.upeu.proyInt.repository.FacultadInterface;
import pe.edu.upeu.proyInt.service.FacultadService;

import java.util.List;

@Service
public class FacultadServiceImpl implements FacultadService {

    @Autowired
    private FacultadInterface facultadInterface;

    @Override
    public List<FacultadEntity> facultadListar() {
        return facultadInterface.findAll();
    }

    @Override
    public FacultadEntity guardarFacultad(FacultadEntity facultadEntity) {
        FacultadEntity nuevoFacultad = new FacultadEntity();
        nuevoFacultad.setFacultad(facultadEntity.getFacultad());
        return facultadInterface.save(nuevoFacultad);
    }

    @Override
    public FacultadEntity editarFacultad(int id, FacultadEntity facultadEntity) {
        FacultadEntity facultadEncontrado = facultadInterface.findById(id).orElse(null);
        if (facultadEntity != null){
            facultadEntity.setFacultad(facultadEntity.getFacultad());
            return facultadInterface.save(facultadEntity);
        }
        return null;
    }

    @Override
    public void eliminarFacultad(int id) {
        facultadInterface.deleteById(id);
    }
}