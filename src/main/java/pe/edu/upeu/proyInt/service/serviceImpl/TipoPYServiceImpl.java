package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.entity.TipoPYEntity;
import pe.edu.upeu.proyInt.repository.TipoPYInterface;
import pe.edu.upeu.proyInt.service.TipoPYService;

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
    public TipoPYEntity guardarTipoPy(TipoPYEntity tipoPyEntity) {
        TipoPYEntity nuevoTipoPy = new TipoPYEntity();
        nuevoTipoPy.setNombre(tipoPyEntity.getNombre());
        return tipoPyInterface.save(nuevoTipoPy);
    }

    @Override
    public TipoPYEntity editarTipoPy(int id, TipoPYEntity tipoPyEntity) {
        TipoPYEntity tipoPyEncontrado = tipoPyInterface.findById(id).orElse(null);
        if (tipoPyEntity != null){
            tipoPyEntity.setNombre(tipoPyEntity.getNombre());
            return tipoPyInterface.save(tipoPyEntity);
        }
        return null;
    }

    @Override
    public void eliminarTipoPy(int id) {
        tipoPyInterface.deleteById(id);
    }
}