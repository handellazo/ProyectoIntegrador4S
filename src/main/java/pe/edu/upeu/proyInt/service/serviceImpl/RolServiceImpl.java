package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.RolDto;
import pe.edu.upeu.proyInt.entity.RolEntity;
import pe.edu.upeu.proyInt.repository.RolInterface;
import pe.edu.upeu.proyInt.service.RolService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolInterface rolInterface;

    @Override
    public List<RolEntity> rolListar() {
        return rolInterface.findAll();
    }

    @Override
    public RolEntity buscarRolPorId(int id) {
        return rolInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public RolEntity guardarRol(RolDto rolDto) {
        RolEntity nuevoRol = new RolEntity();
        nuevoRol.setRol(rolDto.getRol());
        nuevoRol.setDescripcion(rolDto.getDescripcion());
        return rolInterface.save(nuevoRol);
    }

    @Override
    public RolEntity editarRol(int id, RolDto rolDto) {
        RolEntity rolEncontrado = rolInterface.findById(id).orElse(null);
        if (rolEncontrado != null){
            rolEncontrado.setRol(rolDto.getRol());
            rolEncontrado.setDescripcion(rolDto.getDescripcion());
            return rolInterface.save(rolEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarRol(int id) {
        rolInterface.deleteById(id);
    }
}