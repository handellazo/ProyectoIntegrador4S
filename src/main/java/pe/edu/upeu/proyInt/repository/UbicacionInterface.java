package pe.edu.upeu.proyInt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.proyInt.entity.UbicacionEntity;

import java.util.List;

@Repository
public interface UbicacionInterface extends JpaRepository<UbicacionEntity, Integer>{
    List<UbicacionEntity> findByDepartamento(String departamento);
    List<UbicacionEntity> findByProvincia(String provincia);
}
