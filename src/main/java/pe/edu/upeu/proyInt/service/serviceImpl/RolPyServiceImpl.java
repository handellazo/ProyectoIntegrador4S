package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.RolPyDto;
import pe.edu.upeu.proyInt.entity.ProyectoEntity;
import pe.edu.upeu.proyInt.entity.RolEstudianteEntity;
import pe.edu.upeu.proyInt.entity.RolPyEntity;
import pe.edu.upeu.proyInt.repository.ProyectoInterface;
import pe.edu.upeu.proyInt.repository.RolEstudianteInterface;
import pe.edu.upeu.proyInt.repository.RolPyInterface;
import pe.edu.upeu.proyInt.service.RolPyService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class RolPyServiceImpl implements RolPyService {

    @Autowired
    private RolPyInterface rolPyInterface;
    @Autowired
    private RolEstudianteInterface rolEstudianteInterface;
    @Autowired
    private ProyectoInterface proyectoInterface;

    @Override
    public List<RolPyEntity> rolPyListar() {
        return rolPyInterface.findAll();
    }

    @Override
    public RolPyEntity buscarRolPyPorId(int id) {
        return rolPyInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public RolPyEntity guardarRolPy(RolPyDto rolPyDto) {
        RolEstudianteEntity rolEstudianteEncontrado = rolEstudianteInterface.findById(rolPyDto.getRolEst()).orElse(null);
        ProyectoEntity proyectoEncontrado = proyectoInterface.findById(rolPyDto.getProyecto()).orElse(null);

        RolPyEntity nuevoRolPy = new RolPyEntity();
        nuevoRolPy.setHoras(rolPyDto.getHoras());
        nuevoRolPy.setRolEst(rolEstudianteEncontrado);
        nuevoRolPy.setProyecto(proyectoEncontrado);
        return rolPyInterface.save(nuevoRolPy);
    }

    @Override
    public RolPyEntity editarRolPy(int id, RolPyDto rolPyDto) {
        RolPyEntity rolPyEncontrado = rolPyInterface.findById(id).orElse(null);
        RolEstudianteEntity rolEstudianteEncontrado = rolEstudianteInterface.findById(rolPyDto.getRolEst()).orElse(null);
        ProyectoEntity proyectoEncontrado = proyectoInterface.findById(rolPyDto.getProyecto()).orElse(null);

        if (rolPyEncontrado != null){
            rolPyEncontrado.setHoras(rolPyDto.getHoras());
            rolPyEncontrado.setRolEst(rolEstudianteEncontrado);
            rolPyEncontrado.setProyecto(proyectoEncontrado);
            return rolPyInterface.save(rolPyEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarRolPy(int id) {
        rolPyInterface.deleteById(id);
    }
}