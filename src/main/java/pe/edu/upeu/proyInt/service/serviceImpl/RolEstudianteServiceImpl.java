package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.RolEstudianteDto;
import pe.edu.upeu.proyInt.entity.RolEstudianteEntity;
import pe.edu.upeu.proyInt.repository.RolEstudianteInterface;
import pe.edu.upeu.proyInt.service.RolEstudianteService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

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
    public RolEstudianteEntity buscarRolEstudiantePorId(int id) {
        return rolEstudianteInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public RolEstudianteEntity guardarRolEstudiante(RolEstudianteDto rolEstudianteDto) {
        RolEstudianteEntity nuevoRolEstudiante = new RolEstudianteEntity();
        nuevoRolEstudiante.setNombre(rolEstudianteDto.getNombre());
        return rolEstudianteInterface.save(nuevoRolEstudiante);
    }

    @Override
    public RolEstudianteEntity editarRolEstudiante(int id, RolEstudianteDto rolEstudianteDto) {
        RolEstudianteEntity rolEstudianteEncontrado = rolEstudianteInterface.findById(id).orElse(null);
        if (rolEstudianteEncontrado != null){
            rolEstudianteEncontrado.setNombre(rolEstudianteDto.getNombre());
            return rolEstudianteInterface.save(rolEstudianteEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarRolEstudiante(int id) {
        rolEstudianteInterface.deleteById(id);
    }
}