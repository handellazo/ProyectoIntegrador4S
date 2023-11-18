package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.EpDto;
import pe.edu.upeu.proyInt.entity.*;
import pe.edu.upeu.proyInt.repository.*;
import pe.edu.upeu.proyInt.service.EpService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class EpServiceImpl implements EpService {

    @Autowired
    private EpInterface epInterface;
    @Autowired
    private FacultadInterface facultadInterface;

    @Override
    public List<EpEntity> epListar() {
        return epInterface.findAll();
    }

    @Override
    public EpEntity buscarEpPorId(int id) {
        return epInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public EpEntity guardarEp(EpDto epDto) {
        FacultadEntity facultadEncontrado = facultadInterface.findById(epDto.getFacultad()).orElse(null);

        EpEntity nuevoEp = new EpEntity();
        nuevoEp.setNombre(epDto.getNombre());
        nuevoEp.setFacultad(facultadEncontrado);
        return epInterface.save(nuevoEp);
    }

    @Override
    public EpEntity editarEp(int id, EpDto epDto) {
        EpEntity epEncontrado = epInterface.findById(id).orElse(null);
        FacultadEntity facultadEncontrado = facultadInterface.findById(epDto.getFacultad()).orElse(null);


        if (epEncontrado != null){
            epEncontrado.setNombre(epDto.getNombre());
            epEncontrado.setFacultad(facultadEncontrado);
            return epInterface.save(epEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarEp(int id) {
        epInterface.deleteById(id);
    }
}