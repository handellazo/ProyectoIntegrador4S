package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.SesionDto;
import pe.edu.upeu.proyInt.entity.ProyectoEntity;
import pe.edu.upeu.proyInt.entity.SesionEntity;
import pe.edu.upeu.proyInt.repository.ProyectoInterface;
import pe.edu.upeu.proyInt.repository.SesionInterface;
import pe.edu.upeu.proyInt.service.SesionService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class SesionServiceImpl implements SesionService {

    @Autowired
    private SesionInterface sesionInterface;
    @Autowired
    private ProyectoInterface proyectoInterface;

    @Override
    public List<SesionEntity> sesionListar() {
        return sesionInterface.findAll();
    }

    @Override
    public SesionEntity buscarSesionPorId(int id) {
        return sesionInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public SesionEntity guardarSesion(SesionDto sesionDto) {
        ProyectoEntity proyectoEncontrado = proyectoInterface.findById(sesionDto.getProyecto()).orElse(null);

        SesionEntity nuevoSesion = new SesionEntity();
        nuevoSesion.setFecha(sesionDto.getFecha());
        nuevoSesion.setProyecto(proyectoEncontrado);
        return sesionInterface.save(nuevoSesion);
    }

    @Override
    public SesionEntity editarSesion(int id, SesionDto sesionDto) {
        SesionEntity sesionEncontrado = sesionInterface.findById(id).orElse(null);
        ProyectoEntity proyectoEncontrado = proyectoInterface.findById(sesionDto.getProyecto()).orElse(null);

        if (sesionEncontrado != null){
            sesionEncontrado.setFecha(sesionDto.getFecha());
            sesionEncontrado.setProyecto(proyectoEncontrado);
            return sesionInterface.save(sesionEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarSesion(int id) {
        sesionInterface.deleteById(id);
    }
}