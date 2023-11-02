package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.entity.RolEstudianteEntity;
import pe.edu.upeu.proyInt.repository.RolEstudianteInterface;
import pe.edu.upeu.proyInt.service.RolEstudianteService;

import java.util.List;

@Service
public class RolEstudianteServiceImpl implements RolEstudianteService {

    @Autowired
    private RolEstudianteInterface rolEstudianteInterface;

    @Override
    public List<RolEstudianteEntity> rolEstudianteListar() {
        return rolEstudianteInterface.findAll();
    }

    @Override
    public RolEstudianteEntity guardarRolEstudiante(RolEstudianteEntity rolEstudianteEntity) {
        RolEstudianteEntity nuevoRolEstudiante = new RolEstudianteEntity();
        nuevoRolEstudiante.setNombre(rolEstudianteEntity.getNombre());
        return rolEstudianteInterface.save(nuevoRolEstudiante);
    }

    @Override
    public RolEstudianteEntity editarRolEstudiante(int id, RolEstudianteEntity rolEstudianteEntity) {
        RolEstudianteEntity rolEstudianteEncontrado = rolEstudianteInterface.findById(id).orElse(null);
        if (rolEstudianteEntity != null){
            rolEstudianteEncontrado.setNombre(rolEstudianteEntity.getNombre());
            return rolEstudianteInterface.save(rolEstudianteEntity);
        }
        return null;
    }

    @Override
    public void eliminarRolEstudiante(int id) {
        rolEstudianteInterface.deleteById(id);
    }
}