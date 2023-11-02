package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.entity.FacultadEntity;
import pe.edu.upeu.proyInt.service.FacultadService;

import java.util.List;

@RestController
@RequestMapping("/api/FACULTAD")
@CrossOrigin({"*"})
public class FacultadController {
    @Autowired
    private FacultadService facultadService;

    @GetMapping("/listFacultad") //GET
    public ResponseEntity<List<FacultadEntity>> listaFacultades(){
        List<FacultadEntity> facultades = facultadService.facultadListar();
        return new ResponseEntity<>(facultades, HttpStatus.OK);
    };

    @PostMapping("/addFacultad") //POST
    public ResponseEntity<FacultadEntity> crearFacultad(@RequestBody FacultadEntity facultad) {
        FacultadEntity newFacultad = facultadService.guardarFacultad(facultad);
        if (newFacultad != null) {
            return new ResponseEntity<>(newFacultad, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateFacultad/{id}") //PUT
    public ResponseEntity<FacultadEntity> updateFacultad(@PathVariable Integer id, @RequestBody FacultadEntity newFacultad) {
        FacultadEntity updateFacultad = facultadService.editarFacultad(id,newFacultad);
        if (updateFacultad != null) {
            return new ResponseEntity<>(updateFacultad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteFacultad/{id}") //DELETE
    public ResponseEntity<Void> deleteFacultad(@PathVariable Integer id) {
        facultadService.eliminarFacultad(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
