package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.dto.UbicacionDto;
import pe.edu.upeu.proyInt.entity.UbicacionEntity;
import pe.edu.upeu.proyInt.service.UbicacionService;

import java.util.List;

@RestController
@RequestMapping("/api/UBICACION")
@CrossOrigin({"*"})
public class UbicacionController {
    @Autowired
    private UbicacionService ubicacionService;

    @GetMapping("/listUbicacion") //GET
    public ResponseEntity<List<UbicacionEntity>> listaUbicaciones(){
        List<UbicacionEntity> ubicaciones = ubicacionService.ubicacionListar();
        return new ResponseEntity<>(ubicaciones, HttpStatus.OK);
    };

    @GetMapping("/buscarUbicacionPorId/{id}") //GET
    public ResponseEntity<UbicacionEntity> buscarUbicacionPorId(@PathVariable Integer id){
        UbicacionEntity ubicacion = ubicacionService.buscarUbicacionPorId(id);
        return new ResponseEntity<>(ubicacion, HttpStatus.OK);
    }

    @PostMapping("/addUbicacion") //POST
    public ResponseEntity<UbicacionEntity> crearUbicacion(@RequestBody UbicacionDto ubicacion) {
        UbicacionEntity newUbicacion = ubicacionService.guardarUbicacion(ubicacion);
        if (newUbicacion != null) {
            return new ResponseEntity<>(newUbicacion, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateUbicacion/{id}") //PUT
    public ResponseEntity<UbicacionEntity> updateUbicacion(@PathVariable Integer id, @RequestBody UbicacionDto newUbicacion) {
        UbicacionEntity updateUbicacion = ubicacionService.editarUbicacion(id,newUbicacion);
        if (updateUbicacion != null) {
            return new ResponseEntity<>(updateUbicacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteUbicacion/{id}") //DELETE
    public ResponseEntity<Void> deleteUbicacion(@PathVariable Integer id) {
        ubicacionService.eliminarUbicacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/departamento/{departamento}")
    public List<UbicacionEntity> listByDepartamento(@PathVariable String departamento) {
        return ubicacionService.findByDepartamento(departamento);
    }

    @GetMapping("/provincia/{provincia}")
    public List<UbicacionEntity> listByProvincia(@PathVariable String provincia) {
        return ubicacionService.findByProvincia(provincia);
    }
}
