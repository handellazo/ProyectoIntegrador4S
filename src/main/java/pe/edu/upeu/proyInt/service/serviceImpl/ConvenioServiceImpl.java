package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.entity.ConvenioEntity;
import pe.edu.upeu.proyInt.repository.ConvenioInterface;
import pe.edu.upeu.proyInt.service.ConvenioService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class ConvenioServiceImpl implements ConvenioService {

    @Autowired
    private ConvenioInterface convenioInterface;

    @Override
    public List<ConvenioEntity> convenioListar() {
        return convenioInterface.findAll();
    }

    @Override
    public ConvenioEntity buscarConvenioPorID(int id) {
        return convenioInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public ConvenioEntity guardarConvenio(ConvenioEntity convenioEntity) {
        ConvenioEntity nuevoConvenio = new ConvenioEntity();
        nuevoConvenio.setNombre(convenioEntity.getNombre());
        nuevoConvenio.setInicio(convenioEntity.getInicio());
        nuevoConvenio.setFin(convenioEntity.getFin());
        nuevoConvenio.setAnexo(convenioEntity.getAnexo());
        nuevoConvenio.setTipo(convenioEntity.getTipo());
        return convenioInterface.save(nuevoConvenio);
    }

    @Override
    public ConvenioEntity editarConvenio(int id, ConvenioEntity convenioEntity) {
        ConvenioEntity convenioEncontrado = convenioInterface.findById(id).orElse(null);
        if (convenioEncontrado != null){
            convenioEncontrado.setNombre(convenioEntity.getNombre());
            convenioEncontrado.setInicio(convenioEntity.getInicio());
            convenioEncontrado.setFin(convenioEntity.getFin());
            convenioEncontrado.setAnexo(convenioEntity.getAnexo());
            convenioEncontrado.setTipo(convenioEntity.getTipo());
            return convenioInterface.save(convenioEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarConvenio(int id) {
        convenioInterface.deleteById(id);
    }
}