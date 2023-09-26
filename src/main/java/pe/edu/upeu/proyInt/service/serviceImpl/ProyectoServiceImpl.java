package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.entity.ProyectoEntity;
import pe.edu.upeu.proyInt.repository.ProyectoInterface;
import pe.edu.upeu.proyInt.service.ProyectoService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    @Autowired
    private ProyectoInterface proyectoInterface;

    @Override
    public List<ProyectoEntity> proyectoListar() {
        return proyectoInterface.findAll();
    }

    @Override
    public ProyectoEntity buscarProyectoPorID(int id) {
        return proyectoInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public ProyectoEntity guardarProyecto(ProyectoEntity proyectoEntity) {
        ProyectoEntity nuevoProyecto = new ProyectoEntity();
        nuevoProyecto.setNombre(proyectoEntity.getNombre());
        nuevoProyecto.setInicio(proyectoEntity.getInicio());
        nuevoProyecto.setFin(proyectoEntity.getFin());
        nuevoProyecto.setAnexo(proyectoEntity.getAnexo());
        return proyectoInterface.save(nuevoProyecto);
    }

    @Override
    public ProyectoEntity editarProyecto(int id, ProyectoEntity proyectoEntity) {
        ProyectoEntity proyectoEncontrado = proyectoInterface.findById(id).orElse(null);
        if (proyectoEncontrado != null) {
            proyectoEncontrado.setNombre(proyectoEntity.getNombre());
            proyectoEncontrado.setNombre(proyectoEntity.getNombre());
            proyectoEncontrado.setInicio(proyectoEntity.getInicio());
            proyectoEncontrado.setFin(proyectoEntity.getFin());
            proyectoEncontrado.setAnexo(proyectoEntity.getAnexo());
            return proyectoInterface.save(proyectoEncontrado);
        }
        return null;
    }

    @Override
    public void elimirUsuario(int id) {
        proyectoInterface.deleteById(id);
    }
}