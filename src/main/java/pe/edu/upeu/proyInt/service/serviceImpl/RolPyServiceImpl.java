package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.entity.RolPyEntity;
import pe.edu.upeu.proyInt.repository.RolPyInterface;
import pe.edu.upeu.proyInt.service.RolPyService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class RolPyServiceImpl implements RolPyService {

    @Autowired
    private RolPyInterface rolPyInterface;

    @Override
    public List<RolPyEntity> rolPyListar() {
        return rolPyInterface.findAll();
    }

    @Override
    public RolPyEntity guardarRolPy(RolPyEntity rolPyEntity) {
        RolPyEntity nuevoRolPy = new RolPyEntity();
        nuevoRolPy.setHoras(rolPyEntity.getHoras());
        nuevoRolPy.setRolEst(rolPyEntity.getRolEst());
        nuevoRolPy.setProyecto(rolPyEntity.getProyecto());
        return rolPyInterface.save(nuevoRolPy);
    }

    @Override
    public RolPyEntity editarRolPy(int id, RolPyEntity rolPyEntity) {
        RolPyEntity rolPyEncontrado = rolPyInterface.findById(id).orElse(null);
        if (rolPyEncontrado != null){
            rolPyEncontrado.setHoras(rolPyEntity.getHoras());
            rolPyEncontrado.setRolEst(rolPyEntity.getRolEst());
            rolPyEncontrado.setProyecto(rolPyEntity.getProyecto());
            return rolPyInterface.save(rolPyEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarRolPy(int id) {
        rolPyInterface.deleteById(id);
    }
}