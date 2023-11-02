package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.entity.SesionEntity;
import pe.edu.upeu.proyInt.repository.SesionInterface;
import pe.edu.upeu.proyInt.service.SesionService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class SesionServiceImpl implements SesionService {

    @Autowired
    private SesionInterface sesionInterface;

    @Override
    public List<SesionEntity> sesionListar() {
        return sesionInterface.findAll();
    }

    @Override
    public SesionEntity guardarSesion(SesionEntity sesionEntity) {
        SesionEntity nuevoSesion = new SesionEntity();
        nuevoSesion.setFecha(sesionEntity.getFecha());
        nuevoSesion.setProyecto(sesionEntity.getProyecto());
        return sesionInterface.save(nuevoSesion);
    }

    @Override
    public SesionEntity editarSesion(int id, SesionEntity sesionEntity) {
        SesionEntity sesionEncontrado = sesionInterface.findById(id).orElse(null);
        if (sesionEncontrado != null){
            sesionEncontrado.setFecha(sesionEntity.getFecha());
            sesionEncontrado.setProyecto(sesionEntity.getProyecto());
            return sesionInterface.save(sesionEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarSesion(int id) {
        sesionInterface.deleteById(id);
    }
}