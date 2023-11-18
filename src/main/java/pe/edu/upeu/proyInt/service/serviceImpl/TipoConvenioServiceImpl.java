package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.TipoConvenioDto;
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
    public TipoConvenioEntity buscarTipoConvenioPorId(int id) {
        return tipoConvenioInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public TipoConvenioEntity guardarTipoConvenio(TipoConvenioDto tipoConvenioDto) {
        TipoConvenioEntity nuevoTipoConvenio = new TipoConvenioEntity();
        nuevoTipoConvenio.setNombre(tipoConvenioDto.getNombre());
        return tipoConvenioInterface.save(nuevoTipoConvenio);
    }

    @Override
    public TipoConvenioEntity editarTipoConvenio(int id, TipoConvenioDto tipoConvenioDto) {
        TipoConvenioEntity tipoConvenioEncontrado = tipoConvenioInterface.findById(id).orElse(null);
        if (tipoConvenioEncontrado != null){
            tipoConvenioEncontrado.setNombre(tipoConvenioDto.getNombre());
            return tipoConvenioInterface.save(tipoConvenioEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarTipoConvenio(int id) {
        tipoConvenioInterface.deleteById(id);
    }
}