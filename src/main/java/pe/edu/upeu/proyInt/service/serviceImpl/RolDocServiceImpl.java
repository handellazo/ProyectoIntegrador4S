package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.RolDocDto;
import pe.edu.upeu.proyInt.entity.RolDocEntity;
import pe.edu.upeu.proyInt.repository.RolDocInterface;
import pe.edu.upeu.proyInt.service.RolDocService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class RolDocServiceImpl implements RolDocService {

    @Autowired
    private RolDocInterface rolDocInterface;

    @Override
    public List<RolDocEntity> rolDocListar() {
        return rolDocInterface.findAll();
    }

    @Override
    public RolDocEntity buscarRolDocPorId(int id) {
        return rolDocInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public RolDocEntity guardarRolDoc(RolDocDto rolDocDto) {
        RolDocEntity nuevoRolDoc = new RolDocEntity();
        nuevoRolDoc.setRol(rolDocDto.getRol());
        nuevoRolDoc.setDescripcion(rolDocDto.getDescripcion());
        return rolDocInterface.save(nuevoRolDoc);
    }

    @Override
    public RolDocEntity editarRolDoc(int id, RolDocDto rolDocDto) {
        RolDocEntity rolDocEncontrado = rolDocInterface.findById(id).orElse(null);
        if (rolDocEncontrado != null){
            rolDocEncontrado.setRol(rolDocDto.getRol());
            rolDocEncontrado.setDescripcion(rolDocDto.getDescripcion());
            return rolDocInterface.save(rolDocEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarRolDoc(int id) {
        rolDocInterface.deleteById(id);
    }
}