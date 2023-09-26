package pe.edu.upeu.proyInt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.proyInt.entity.UbicacionEntity;

@Repository
public interface UbicacionInterface extends JpaRepository<UbicacionEntity, Integer>{

}
