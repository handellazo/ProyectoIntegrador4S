package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.entity.UbicacionEntity;
import pe.edu.upeu.proyInt.repository.UbicacionInterface;
import pe.edu.upeu.proyInt.service.UbicacionService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class UbicacionServiceImpl implements UbicacionService {

    @Autowired
    private UbicacionInterface ubicacionInterface;

    @Override
    public List<UbicacionEntity> ubicacionListar() {
        return ubicacionInterface.findAll();
    }

    @Override
    public UbicacionEntity buscarUbicacionPorID(int id) {
        return ubicacionInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public UbicacionEntity guardarUbicacion(UbicacionEntity ubicacionEntity) {
        UbicacionEntity nuevoUbicacion = new UbicacionEntity();
        nuevoUbicacion.setDistrito(ubicacionEntity.getDistrito());
        nuevoUbicacion.setProvincia(ubicacionEntity.getProvincia());
        nuevoUbicacion.setDepartamento(ubicacionEntity.getDepartamento());
        return ubicacionInterface.save(nuevoUbicacion);
    }

    @Override
    public UbicacionEntity editarUbicacion(int id, UbicacionEntity ubicacionEntity) {
        UbicacionEntity ubicacionEncontrado = ubicacionInterface.findById(id).orElse(null);
        if (ubicacionEncontrado != null){
            ubicacionEncontrado.setDistrito(ubicacionEntity.getDistrito());
            ubicacionEncontrado.setProvincia(ubicacionEntity.getProvincia());
            ubicacionEncontrado.setDepartamento(ubicacionEntity.getDepartamento());
            return ubicacionInterface.save(ubicacionEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarUbicacion(int id) {
        ubicacionInterface.deleteById(id);
    }
}