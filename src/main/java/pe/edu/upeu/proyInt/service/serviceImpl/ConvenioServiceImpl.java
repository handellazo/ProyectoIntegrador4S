package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.ConvenioDto;
import pe.edu.upeu.proyInt.entity.*;
import pe.edu.upeu.proyInt.repository.*;
import pe.edu.upeu.proyInt.service.ConvenioService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class ConvenioServiceImpl implements ConvenioService {

    @Autowired
    private ConvenioInterface convenioInterface;
    @Autowired
    private TipoConvenioInterface tipoConvenioInterface;
    @Autowired
    private UbicacionInterface ubicacionInterface;

    @Override
    public List<ConvenioEntity> convenioListar() {
        return convenioInterface.findAll();
    }

    @Override
    public ConvenioEntity buscarConvenioPorId(int id) {
        return convenioInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public ConvenioEntity guardarConvenio(ConvenioDto convenioDto) {
        TipoConvenioEntity tipoConvenioEncontrado = tipoConvenioInterface.findById(convenioDto.getTipo()).orElse(null);
        UbicacionEntity ubicacionEncontrado = ubicacionInterface.findById(convenioDto.getUbicacion()).orElse(null);

        ConvenioEntity nuevoConvenio = new ConvenioEntity();
        nuevoConvenio.setNombre(convenioDto.getNombre());
        nuevoConvenio.setInicio(convenioDto.getInicio());
        nuevoConvenio.setFin(convenioDto.getFin());
        nuevoConvenio.setReferencia(convenioDto.getReferencia());
        nuevoConvenio.setTipo(tipoConvenioEncontrado); //FK
        nuevoConvenio.setUbicacion(ubicacionEncontrado); //FK
        nuevoConvenio.setArchivo(convenioDto.getArchivo());
        nuevoConvenio.setEstado(Integer.valueOf(convenioDto.getEstado()));
        return convenioInterface.save(nuevoConvenio);
    }

    @Override
    public ConvenioEntity editarConvenio(int id, ConvenioDto convenioDto) {
        ConvenioEntity convenioEncontrado = convenioInterface.findById(id).orElse(null);
        TipoConvenioEntity tipoConvenioEncontrado = tipoConvenioInterface.findById(convenioDto.getTipo()).orElse(null);
        UbicacionEntity ubicacionEncontrado = ubicacionInterface.findById(convenioDto.getUbicacion()).orElse(null);


        if (convenioEncontrado != null){
            convenioEncontrado.setNombre(convenioDto.getNombre());
            convenioEncontrado.setInicio(convenioDto.getInicio());
            convenioEncontrado.setFin(convenioDto.getFin());
            convenioEncontrado.setReferencia(convenioDto.getReferencia());
            convenioEncontrado.setTipo(tipoConvenioEncontrado);
            convenioEncontrado.setUbicacion(ubicacionEncontrado);
            convenioEncontrado.setArchivo(convenioDto.getArchivo());
            convenioEncontrado.setEstado(Integer.valueOf(convenioDto.getEstado()));
            return convenioInterface.save(convenioEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarConvenio(int id) {
        convenioInterface.deleteById(id);
    }
}