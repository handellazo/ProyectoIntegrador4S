package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.entity.SesionEntity;
import pe.edu.upeu.proyInt.service.SesionService;

import java.util.List;

@RestController
@RequestMapping("/api/SESION")
@CrossOrigin({"*"})
public class SesionController {
    @Autowired
    private SesionService sesionService;

    @GetMapping("/listSesion") //GET
    public ResponseEntity<List<SesionEntity>> listaSesions(){
        List<SesionEntity> sesions = sesionService.sesionListar();
        return new ResponseEntity<>(sesions, HttpStatus.OK);
    };

    @PostMapping("/addSesion") //POST
    public ResponseEntity<SesionEntity> crearSesion(@RequestBody SesionEntity sesion) {
        SesionEntity newSesion = sesionService.guardarSesion(sesion);
        if (newSesion != null) {
            return new ResponseEntity<>(newSesion, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateSesion/{id}") //PUT
    public ResponseEntity<SesionEntity> updateSesion(@PathVariable Integer id, @RequestBody SesionEntity newSesion) {
        SesionEntity updateSesion = sesionService.editarSesion(id,newSesion);
        if (updateSesion != null) {
            return new ResponseEntity<>(updateSesion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteSesion/{id}") //DELETE
    public ResponseEntity<Void> deleteSesion(@PathVariable Integer id) {
        sesionService.eliminarSesion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
