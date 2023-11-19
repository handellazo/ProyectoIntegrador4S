package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.dto.EstadoProyDto;
import pe.edu.upeu.proyInt.entity.EstadoProyEntity;
import pe.edu.upeu.proyInt.service.EstadoProyService;

import java.util.List;

@RestController
@RequestMapping("/api/ESTADOPROY")
@CrossOrigin({"*"})
public class EstadoProyController {
    @Autowired
    private EstadoProyService estadoProyService;

    @GetMapping("/listEstadoProy") //GET
    public ResponseEntity<List<EstadoProyEntity>> listaEstadoProys(){
        List<EstadoProyEntity> estadoProys = estadoProyService.estadoProyListar();
        return new ResponseEntity<>(estadoProys, HttpStatus.OK);
    };

    @GetMapping("/buscarEstadoProyPorId/{id}") //GET
    public ResponseEntity<EstadoProyEntity> buscarEstadoProyPorId(@PathVariable Integer id){
        EstadoProyEntity estadoProy = estadoProyService.buscarEstadoProyPorId(id);
        return new ResponseEntity<>(estadoProy, HttpStatus.OK);
    }

    @PostMapping("/addEstadoProy") //POST
    public ResponseEntity<EstadoProyEntity> crearEstadoProy(@RequestBody EstadoProyDto estadoProy) {
        EstadoProyEntity newEstadoProy = estadoProyService.guardarEstadoProy(estadoProy);
        if (newEstadoProy != null) {
            return new ResponseEntity<>(newEstadoProy, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateEstadoProy/{id}") //PUT
    public ResponseEntity<EstadoProyEntity> updateEstadoProy(@PathVariable Integer id, @RequestBody EstadoProyDto newEstadoProy) {
        EstadoProyEntity updateEstadoProy = estadoProyService.editarEstadoProy(id,newEstadoProy);
        if (updateEstadoProy != null) {
            return new ResponseEntity<>(updateEstadoProy, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteEstadoProy/{id}") //DELETE
    public ResponseEntity<Void> deleteCurso(@PathVariable Integer id) {
        estadoProyService.eliminarEstadoProy(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
