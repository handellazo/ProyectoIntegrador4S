package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.TipoPYEntity;

import java.util.List;

public interface TipoPYService {
    List<TipoPYEntity> tipoPyListar();
    TipoPYEntity guardarTipoPy(TipoPYEntity tipoPyEntity);
    TipoPYEntity editarTipoPy(int id, TipoPYEntity tipoPyEntity);
    void eliminarTipoPy(int id);
}
