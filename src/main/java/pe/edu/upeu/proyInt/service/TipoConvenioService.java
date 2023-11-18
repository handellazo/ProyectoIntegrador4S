package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.TipoConvenioDto;
import pe.edu.upeu.proyInt.entity.ProyectoEntity;
import pe.edu.upeu.proyInt.entity.TipoConvenioEntity;

import java.util.List;

public interface TipoConvenioService {
    List<TipoConvenioEntity> tipoConvenioListar();
    TipoConvenioEntity buscarTipoConvenioPorId(int id);
    TipoConvenioEntity guardarTipoConvenio(TipoConvenioDto tipoConvenioDto);
    TipoConvenioEntity editarTipoConvenio(int id, TipoConvenioDto tipoConvenioDto);
    void eliminarTipoConvenio(int id);
}
