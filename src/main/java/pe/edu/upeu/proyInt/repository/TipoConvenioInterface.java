package pe.edu.upeu.proyInt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.proyInt.entity.TipoConvenioEntity;

@Repository
public interface TipoConvenioInterface extends JpaRepository<TipoConvenioEntity, Integer>{
    /*@Query("")
    TipoConvenioEntity findByDepartamento(String departamento);
    TipoConvenioEntity findByProvincia(String provincia);
    List<TipoConvenioEntity> listDepartamento();*/
}
