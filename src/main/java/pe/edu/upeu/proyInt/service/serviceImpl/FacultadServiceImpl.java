package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.FacultadDto;
import pe.edu.upeu.proyInt.entity.FacultadEntity;
import pe.edu.upeu.proyInt.repository.FacultadInterface;
import pe.edu.upeu.proyInt.service.FacultadService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class FacultadServiceImpl implements FacultadService {

    @Autowired
    private FacultadInterface facultadInterface;

    @Override
    public List<FacultadEntity> facultadListar() {
        return facultadInterface.findAll();
    }

    @Override
    public FacultadEntity buscarFacultadPorId(int id) {
        return facultadInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public FacultadEntity guardarFacultad(FacultadDto facultadDto) {
        FacultadEntity nuevoFacultad = new FacultadEntity();
        nuevoFacultad.setNombre(facultadDto.getNombre());
        return facultadInterface.save(nuevoFacultad);
    }

    @Override
    public FacultadEntity editarFacultad(int id, FacultadDto facultadDto) {
        FacultadEntity facultadEncontrado = facultadInterface.findById(id).orElse(null);
        if (facultadEncontrado != null){
            facultadEncontrado.setNombre(facultadDto.getNombre());
            return facultadInterface.save(facultadEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarFacultad(int id) {
        facultadInterface.deleteById(id);
    }
}