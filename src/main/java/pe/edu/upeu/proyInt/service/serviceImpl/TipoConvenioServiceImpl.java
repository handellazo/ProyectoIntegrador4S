package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.entity.TipoConvenioEntity;
import pe.edu.upeu.proyInt.repository.TipoConvenioInterface;
import pe.edu.upeu.proyInt.service.TipoConvenioService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class TipoConvenioServiceImpl implements TipoConvenioService {

    @Autowired
    private TipoConvenioInterface tipoConvenioInterface;

    @Override
    public List<TipoConvenioEntity> tipoConvenioListar() {
        return tipoConvenioInterface.findAll();
    }

    @Override
    public TipoConvenioEntity guardarTipoConvenio(TipoConvenioEntity tipoConvenioEntity) {
        TipoConvenioEntity nuevoTipoConvenio = new TipoConvenioEntity();
        nuevoTipoConvenio.setTipo(tipoConvenioEntity.getTipo());
        return tipoConvenioInterface.save(nuevoTipoConvenio);
    }

    @Override
    public TipoConvenioEntity editarTipoConvenio(int id, TipoConvenioEntity tipoConvenioEntity) {
        TipoConvenioEntity tipoConvenioEncontrado = tipoConvenioInterface.findById(id).orElse(null);
        if (tipoConvenioEntity != null){
            tipoConvenioEntity.setTipo(tipoConvenioEntity.getTipo());
            return tipoConvenioInterface.save(tipoConvenioEntity);
        }
        return null;
    }

    @Override
    public void eliminarTipoConvenio(int id) {
        tipoConvenioInterface.deleteById(id);
    }
}