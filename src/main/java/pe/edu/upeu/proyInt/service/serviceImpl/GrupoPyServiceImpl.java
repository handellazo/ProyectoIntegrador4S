package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.entity.GrupoPyEntity;
import pe.edu.upeu.proyInt.repository.GrupoPyInterface;
import pe.edu.upeu.proyInt.service.GrupoPyService;

import java.util.List;

@Service
public class GrupoPyServiceImpl implements GrupoPyService {

    @Autowired
    private GrupoPyInterface grupoPyInterface;

    @Override
    public List<GrupoPyEntity> grupoPyListar() {
        return grupoPyInterface.findAll();
    }

    @Override
    public GrupoPyEntity guardarGrupoPy(GrupoPyEntity grupoPyEntity) {
        GrupoPyEntity nuevoGrupoPy = new GrupoPyEntity();
        nuevoGrupoPy.setNombre(grupoPyEntity.getNombre());
        nuevoGrupoPy.setProyecto(grupoPyEntity.getProyecto());
        nuevoGrupoPy.setSesion(grupoPyEntity.getSesion());
        return grupoPyInterface.save(nuevoGrupoPy);
    }

    @Override
    public GrupoPyEntity editarGrupoPy(int id, GrupoPyEntity grupoPyEntity) {
        GrupoPyEntity grupoPyEncontrado = grupoPyInterface.findById(id).orElse(null);
        if (grupoPyEntity != null){
            grupoPyEncontrado.setNombre(grupoPyEntity.getNombre());
            grupoPyEncontrado.setProyecto(grupoPyEntity.getProyecto());
            grupoPyEncontrado.setSesion(grupoPyEntity.getSesion());
            return grupoPyInterface.save(grupoPyEntity);
        }
        return null;
    }

    @Override
    public void eliminarGrupoPy(int id) {
        grupoPyInterface.deleteById(id);
    }
}