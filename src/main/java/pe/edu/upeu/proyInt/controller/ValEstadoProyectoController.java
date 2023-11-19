package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.dto.ValEstadoProyDto;
import pe.edu.upeu.proyInt.entity.ValEstadoProyEntity;
import pe.edu.upeu.proyInt.service.ValEstadoProyService;

import java.util.List;

@RestController
@RequestMapping("/api/VALESTADOPROY")
@CrossOrigin({"*"})
public class ValEstadoProyectoController {
    @Autowired
    private ValEstadoProyService valEstadoProyService;

    @GetMapping("/listValEstadoProy") //GET
    public ResponseEntity<List<ValEstadoProyEntity>> listaValEstadoProys(){
        List<ValEstadoProyEntity> valEstadoProys = valEstadoProyService.valEstadoProyListar();
        return new ResponseEntity<>(valEstadoProys, HttpStatus.OK);
    };

    @GetMapping("/buscarValEstadoProyPorId/{id}") //GET
    public ResponseEntity<ValEstadoProyEntity> buscarValEstadoProyPorId(@PathVariable Integer id){
        ValEstadoProyEntity valEstadoProy = valEstadoProyService.buscarValEstadoProyPorId(id);
        return new ResponseEntity<>(valEstadoProy, HttpStatus.OK);
    }

    @PostMapping("/addValEstadoProy") //POST
    public ResponseEntity<ValEstadoProyEntity> crearValEstadoProy(@RequestBody ValEstadoProyDto valEstadoProy) {
        ValEstadoProyEntity newValEstadoProy = valEstadoProyService.guardarValEstadoProy(valEstadoProy);
        if (newValEstadoProy != null) {
            return new ResponseEntity<>(newValEstadoProy, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateValEstadoProy/{id}") //PUT
    public ResponseEntity<ValEstadoProyEntity> updateValEstadoProy(@PathVariable Integer id, @RequestBody ValEstadoProyDto newValEstadoProy) {
        ValEstadoProyEntity updateValEstadoProy = valEstadoProyService.editarValEstadoProy(id,newValEstadoProy);
        if (updateValEstadoProy != null) {
            return new ResponseEntity<>(updateValEstadoProy, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteValEstadoProy/{id}") //DELETE
    public ResponseEntity<Void> deleteValEstadoProy(@PathVariable Integer id) {
        valEstadoProyService.eliminarValEstadoProy(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
