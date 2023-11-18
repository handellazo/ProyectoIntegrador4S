package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.dto.RolDto;
import pe.edu.upeu.proyInt.entity.RolEntity;
import pe.edu.upeu.proyInt.service.RolService;

import java.util.List;

@RestController
@RequestMapping("/api/ROL")
@CrossOrigin({"*"})
public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping("/listRol") //GET
    public ResponseEntity<List<RolEntity>> listaRoles(){
        List<RolEntity> roles = rolService.rolListar();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    };

    @GetMapping("/buscarRolPorId/{id}") //GET
    public ResponseEntity<RolEntity> buscarRolPorId(@PathVariable Integer id){
        RolEntity rol = rolService.buscarRolPorId(id);
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }

    @PostMapping("/addRol") //POST
    public ResponseEntity<RolEntity> crearRol(@RequestBody RolDto rol) {
        RolEntity newRol = rolService.guardarRol(rol);
        if (newRol != null) {
            return new ResponseEntity<>(newRol, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateRol/{id}") //PUT
    public ResponseEntity<RolEntity> updateRol(@PathVariable Integer id, @RequestBody RolDto newRol) {
        RolEntity updateRol = rolService.editarRol(id,newRol);
        if (updateRol != null) {
            return new ResponseEntity<>(updateRol, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteRol/{id}") //DELETE
    public ResponseEntity<Void> deleteRol(@PathVariable Integer id) {
        rolService.eliminarRol(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
