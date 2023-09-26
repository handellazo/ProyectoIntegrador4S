package pe.edu.upeu.proyInt.service;

import pe.edu.upeu.proyInt.entity.ParticipacionEntity;

import java.util.List;

public interface ParticipacionService {
    List<ParticipacionEntity> participacionListar();
    ParticipacionEntity buscarParticipacionPorID(int id);
    ParticipacionEntity guardarParticipacion(ParticipacionEntity participacionEntity);
    ParticipacionEntity editarParticipacion(int id, ParticipacionEntity participacionEntity);
    void eliminarParticipacion(int id);
}
