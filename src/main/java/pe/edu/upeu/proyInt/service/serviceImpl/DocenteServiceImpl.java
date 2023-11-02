package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.entity.DocenteEntity;
import pe.edu.upeu.proyInt.repository.DocenteInterface;
import pe.edu.upeu.proyInt.service.DocenteService;

import java.util.List;

@Service
public class DocenteServiceImpl implements DocenteService {

    @Autowired
    private DocenteInterface docenteInterface;

    @Override
    public List<DocenteEntity> docenteListar() {
        return docenteInterface.findAll();
    }

    @Override
    public DocenteEntity guardarDocente(DocenteEntity docenteEntity) {
        DocenteEntity nuevoDocente = new DocenteEntity();
        nuevoDocente.setPersona(docenteEntity.getPersona());
        nuevoDocente.setEp(docenteEntity.getEp());
        return docenteInterface.save(nuevoDocente);
    }

    @Override
    public DocenteEntity editarDocente(int id, DocenteEntity docenteEntity) {
        DocenteEntity docenteEncontrado = docenteInterface.findById(id).orElse(null);
        if (docenteEntity != null){
            docenteEncontrado.setPersona(docenteEntity.getPersona());
            docenteEncontrado.setEp(docenteEntity.getEp());
            return docenteInterface.save(docenteEntity);
        }
        return null;
    }

    @Override
    public void eliminarDocente(int id) {
        docenteInterface.deleteById(id);
    }
}