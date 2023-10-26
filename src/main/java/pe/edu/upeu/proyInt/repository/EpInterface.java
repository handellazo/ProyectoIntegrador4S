package pe.edu.upeu.proyInt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.proyInt.entity.EpEntity;

@Repository
public interface EpInterface extends JpaRepository<EpEntity, Integer>{
    /*@Query("")
    EpEntity findByDepartamento(String departamento);
    EpEntity findByProvincia(String provincia);
    List<EpEntity> listDepartamento();*/
}
