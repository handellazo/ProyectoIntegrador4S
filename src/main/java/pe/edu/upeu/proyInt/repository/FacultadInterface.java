package pe.edu.upeu.proyInt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.proyInt.entity.FacultadEntity;

@Repository
public interface FacultadInterface extends JpaRepository<FacultadEntity, Integer>{
    /*@Query("")
    FacultadEntity findByDepartamento(String departamento);
    FacultadEntity findByProvincia(String provincia);
    List<FacultadEntity> listDepartamento();*/
}
