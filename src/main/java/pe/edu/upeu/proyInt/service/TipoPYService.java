package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.dto.TipoPyDto;
import pe.edu.upeu.proyInt.entity.ProyectoEntity;
import pe.edu.upeu.proyInt.entity.TipoPYEntity;

import java.util.List;

public interface TipoPYService {
    List<TipoPYEntity> tipoPyListar();
    TipoPYEntity buscarTipoPyPorId(int id);
    TipoPYEntity guardarTipoPy(TipoPyDto tipoPyDto);
    TipoPYEntity editarTipoPy(int id, TipoPyDto tipoPyDto);
    void eliminarTipoPy(int id);
}
