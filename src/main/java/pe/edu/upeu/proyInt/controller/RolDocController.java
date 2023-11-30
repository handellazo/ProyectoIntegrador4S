package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.dto.RolDocDto;
import pe.edu.upeu.proyInt.entity.RolDocEntity;
import pe.edu.upeu.proyInt.service.RolDocService;

import java.util.List;

@RestController
@RequestMapping("/api/ROLDOC")
@CrossOrigin(origins = {"http://localhost:4200, http://localhost:8080 "})
public class RolDocController {
    @Autowired
    private RolDocService rolDocService;

    @GetMapping("/listRolDoc") //GET
    public ResponseEntity<List<RolDocEntity>> listaRolesDoc(){
        List<RolDocEntity> rolesDoc = rolDocService.rolDocListar();
        return new ResponseEntity<>(rolesDoc, HttpStatus.OK);
    };

    @GetMapping("/buscarRolDocPorId/{id}") //GET
    public ResponseEntity<RolDocEntity> buscarRolDocPorId(@PathVariable Integer id){
        RolDocEntity rolDoc = rolDocService.buscarRolDocPorId(id);
        return new ResponseEntity<>(rolDoc, HttpStatus.OK);
    }

    @PostMapping("/addRolDoc") //POST
    public ResponseEntity<RolDocEntity> crearRolDoc(@RequestBody RolDocDto rolDoc) {
        RolDocEntity newRolDoc = rolDocService.guardarRolDoc(rolDoc);
        if (newRolDoc != null) {
            return new ResponseEntity<>(newRolDoc, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateRolDoc/{id}") //PUT
    public ResponseEntity<RolDocEntity> updateRolDoc(@PathVariable Integer id, @RequestBody RolDocDto newRolDoc) {
        RolDocEntity updateRolDoc = rolDocService.editarRolDoc(id,newRolDoc);
        if (updateRolDoc != null) {
            return new ResponseEntity<>(updateRolDoc, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteRolDoc/{id}") //DELETE
    public ResponseEntity<Void> deleteRolDoc(@PathVariable Integer id) {
        rolDocService.eliminarRolDoc(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
