package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.EstadoProyDto;
import pe.edu.upeu.proyInt.entity.EstadoProyEntity;
import pe.edu.upeu.proyInt.repository.EstadoProyInterface;
import pe.edu.upeu.proyInt.service.EstadoProyService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class EstadoProyServiceImpl implements EstadoProyService {

    @Autowired
    private EstadoProyInterface estadoProyInterface;

    @Override
    public List<EstadoProyEntity> estadoProyListar() {
        return estadoProyInterface.findAll();
    }

    @Override
    public EstadoProyEntity buscarEstadoProyPorId(int id) {
        return estadoProyInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public EstadoProyEntity guardarEstadoProy(EstadoProyDto estadoProyDto) {
        EstadoProyEntity nuevoEstadoProy = new EstadoProyEntity();
        nuevoEstadoProy.setNombre(estadoProyDto.getNombre());
        return estadoProyInterface.save(nuevoEstadoProy);
    }

    @Override
    public EstadoProyEntity editarEstadoProy(int id, EstadoProyDto estadoProyDto) {
        EstadoProyEntity estadoProyEncontrado = estadoProyInterface.findById(id).orElse(null);
        if (estadoProyEncontrado != null){
            estadoProyEncontrado.setNombre(estadoProyDto.getNombre());
            return estadoProyInterface.save(estadoProyEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarEstadoProy(int id) {
        estadoProyInterface.deleteById(id);
    }
}