package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.UbicacionDto;
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
    public UbicacionEntity buscarUbicacionPorId(int id) {
        return ubicacionInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public List<UbicacionEntity> findByDepartamento(String departamento) {
        return ubicacionInterface.findByDepartamento(departamento);
    }

    @Override
    public List<UbicacionEntity> findByProvincia(String provincia) {
        return ubicacionInterface.findByProvincia(provincia);
    }


    @Override
    public List<UbicacionEntity> depListar() {
        return null;
    }

    @Override
    public UbicacionEntity guardarUbicacion(UbicacionDto ubicacionDto) {
        UbicacionEntity nuevoUbicacion = new UbicacionEntity();
        nuevoUbicacion.setDistrito(ubicacionDto.getDistrito());
        nuevoUbicacion.setProvincia(ubicacionDto.getProvincia());
        nuevoUbicacion.setDepartamento(ubicacionDto.getDepartamento());
        return ubicacionInterface.save(nuevoUbicacion);
    }

    @Override
    public UbicacionEntity editarUbicacion(int id, UbicacionDto ubicacionDto) {
        UbicacionEntity ubicacionEncontrado = ubicacionInterface.findById(id).orElse(null);
        if (ubicacionEncontrado != null){
            ubicacionEncontrado.setDistrito(ubicacionDto.getDistrito());
            ubicacionEncontrado.setProvincia(ubicacionDto.getProvincia());
            ubicacionEncontrado.setDepartamento(ubicacionDto.getDepartamento());
            return ubicacionInterface.save(ubicacionEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarUbicacion(int id) {
        ubicacionInterface.deleteById(id);
    }
}