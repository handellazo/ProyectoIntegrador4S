package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.TipoConvenioEntity;

import java.util.List;

public interface TipoConvenioService {
    List<TipoConvenioEntity> tipoConvenioListar();
    TipoConvenioEntity guardarTipoConvenio(TipoConvenioEntity tipoConvenioEntity);
    TipoConvenioEntity editarTipoConvenio(int id, TipoConvenioEntity tipoConvenioEntity);
    void eliminarTipoConvenio(int id);
}
