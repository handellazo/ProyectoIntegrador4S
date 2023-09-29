package pe.edu.upeu.proyInt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.proyInt.entity.UbicacionEntity;

import java.util.List;

@Repository
public interface UbicacionInterface extends JpaRepository<UbicacionEntity, Integer>{
    /*@Query("")
    UbicacionEntity findByDepartamento(String departamento);
    UbicacionEntity findByProvincia(String provincia);
    List<UbicacionEntity> listDepartamento();*/
}
