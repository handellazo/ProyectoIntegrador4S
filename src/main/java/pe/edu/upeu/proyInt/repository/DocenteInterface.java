package pe.edu.upeu.proyInt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.proyInt.entity.DocenteEntity;

@Repository
public interface DocenteInterface extends JpaRepository<DocenteEntity, Integer>{
    /*@Query("")
    DocenteEntity findByDepartamento(String departamento);
    DocenteEntity findByProvincia(String provincia);
    List<DocenteEntity> listDepartamento();*/
}
