package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public RolDocEntity guardarRolDoc(RolDocEntity rolDocEntity) {
        RolDocEntity nuevoRolDoc = new RolDocEntity();
        nuevoRolDoc.setRol(rolDocEntity.getRol());
        nuevoRolDoc.setDescripcion(rolDocEntity.getDescripcion());
        return rolDocInterface.save(nuevoRolDoc);
    }

    @Override
    public RolDocEntity editarRolDoc(int id, RolDocEntity rolDocEntity) {
        RolDocEntity rolDocEncontrado = rolDocInterface.findById(id).orElse(null);
        if (rolDocEncontrado != null){
            rolDocEncontrado.setRol(rolDocEntity.getRol());
            rolDocEncontrado.setDescripcion(rolDocEntity.getDescripcion());
            return rolDocInterface.save(rolDocEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarRolDoc(int id) {
        rolDocInterface.deleteById(id);
    }
}