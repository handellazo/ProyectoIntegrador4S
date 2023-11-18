package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.TipoPyDto;
import pe.edu.upeu.proyInt.entity.TipoPYEntity;
import pe.edu.upeu.proyInt.repository.TipoPYInterface;
import pe.edu.upeu.proyInt.service.TipoPYService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class TipoPYServiceImpl implements TipoPYService {

    @Autowired
    private TipoPYInterface tipoPyInterface;

    @Override
    public List<TipoPYEntity> tipoPyListar() {
        return tipoPyInterface.findAll();
    }

    @Override
    public TipoPYEntity buscarTipoPyPorId(int id) {
        return tipoPyInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public TipoPYEntity guardarTipoPy(TipoPyDto tipoPyDto) {
        TipoPYEntity nuevoTipoPy = new TipoPYEntity();
        nuevoTipoPy.setNombre(tipoPyDto.getNombre());
        return tipoPyInterface.save(nuevoTipoPy);
    }

    @Override
    public TipoPYEntity editarTipoPy(int id, TipoPyDto tipoPyDto) {
        TipoPYEntity tipoPyEncontrado = tipoPyInterface.findById(id).orElse(null);
        if (tipoPyEncontrado != null){
            tipoPyEncontrado.setNombre(tipoPyDto.getNombre());
            return tipoPyInterface.save(tipoPyEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarTipoPy(int id) {
        tipoPyInterface.deleteById(id);
    }
}