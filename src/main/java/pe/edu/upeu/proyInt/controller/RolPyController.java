package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.dto.RolPyDto;
import pe.edu.upeu.proyInt.entity.RolPyEntity;
import pe.edu.upeu.proyInt.service.RolPyService;

import java.util.List;

@RestController
@RequestMapping("/api/ROLPY")
@CrossOrigin(origins = {"http://localhost:4200, http://localhost:8080 "})
public class RolPyController {
    @Autowired
    private RolPyService rolPyService;

    @GetMapping("/listRolPy") //GET
    public ResponseEntity<List<RolPyEntity>> listaRolPys(){
        List<RolPyEntity> rolPys = rolPyService.rolPyListar();
        return new ResponseEntity<>(rolPys, HttpStatus.OK);
    };

    @GetMapping("/buscarRolPyPorId/{id}") //GET
    public ResponseEntity<RolPyEntity> buscarRolPyporId(@PathVariable Integer id){
        RolPyEntity rolPy = rolPyService.buscarRolPyPorId(id);
        return new ResponseEntity<>(rolPy, HttpStatus.OK);
    }

    @PostMapping("/addRolPy") //POST
    public ResponseEntity<RolPyEntity> crearRolPy(@RequestBody RolPyDto rolPy) {
        RolPyEntity newRolPy = rolPyService.guardarRolPy(rolPy);
        if (newRolPy != null) {
            return new ResponseEntity<>(newRolPy, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateRolPy/{id}") //PUT
    public ResponseEntity<RolPyEntity> updateRolPy(@PathVariable Integer id, @RequestBody RolPyDto newRolPy) {
        RolPyEntity updateRolPy = rolPyService.editarRolPy(id,newRolPy);
        if (updateRolPy != null) {
            return new ResponseEntity<>(updateRolPy, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteRolPy/{id}") //DELETE
    public ResponseEntity<Void> deleteRolPy(@PathVariable Integer id) {
        rolPyService.eliminarRolPy(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
