package pe.edu.upeu.proyInt.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.proyInt.dto.DocenteDto;
import pe.edu.upeu.proyInt.entity.*;
import pe.edu.upeu.proyInt.repository.*;
import pe.edu.upeu.proyInt.service.DocenteService;
import pe.edu.upeu.proyInt.service.exception.EntityNotFoundException;

import java.util.List;

@Service
public class DocenteServiceImpl implements DocenteService {

    @Autowired
    private DocenteInterface docenteInterface;
    @Autowired
    private PersonaInterface personaInterface;
    @Autowired
    private EpInterface epInterface;

    @Override
    public List<DocenteEntity> docenteListar() {
        return docenteInterface.findAll();
    }

    @Override
    public DocenteEntity buscarDocentePorId(int id) {
        return docenteInterface.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encuentra datos con el ID: " + id)
                );
    }

    @Override
    public DocenteEntity guardarDocente(DocenteDto docenteDto) {
        PersonaEntity personaEncontrado = personaInterface.findById(docenteDto.getPersona()).orElse(null);
        EpEntity epEncontrado = epInterface.findById(docenteDto.getEp()).orElse(null);

        DocenteEntity nuevoDocente = new DocenteEntity();
        nuevoDocente.setPersona(personaEncontrado);
        nuevoDocente.setEp(epEncontrado);
        return docenteInterface.save(nuevoDocente);
    }

    @Override
    public DocenteEntity editarDocente(int id, DocenteDto docenteDto) {
        DocenteEntity docenteEncontrado = docenteInterface.findById(id).orElse(null);
        PersonaEntity personaEncontrado = personaInterface.findById(docenteDto.getPersona()).orElse(null);
        EpEntity epEncontrado = epInterface.findById(docenteDto.getEp()).orElse(null);

        if (docenteEncontrado != null){
            docenteEncontrado.setPersona(personaEncontrado);
            docenteEncontrado.setEp(epEncontrado);
            return docenteInterface.save(docenteEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarDocente(int id) {
        docenteInterface.deleteById(id);
    }
}