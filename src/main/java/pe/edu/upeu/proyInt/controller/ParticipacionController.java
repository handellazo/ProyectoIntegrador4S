package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.entity.ParticipacionEntity;
import pe.edu.upeu.proyInt.service.ParticipacionService;

import java.util.List;

@RestController
@RequestMapping("/api/PARTICIPACION")
@CrossOrigin({"*"})
public class ParticipacionController {
    @Autowired
    private ParticipacionService participacionService;

    @GetMapping("/listParticipacion") //GET
    public ResponseEntity<List<ParticipacionEntity>> listaParticipacion(){
        List<ParticipacionEntity> participaciones = participacionService.participacionListar();
        return new ResponseEntity<>(participaciones, HttpStatus.OK);
    };

    @PostMapping("/addParticipacion") //POST
    public ResponseEntity<ParticipacionEntity> crearParticipacion(@RequestBody ParticipacionEntity participacion) {
        ParticipacionEntity newParticipacion = participacionService.guardarParticipacion(participacion);
        if (newParticipacion != null) {
            return new ResponseEntity<>(newParticipacion, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateParticipacion/{id}") //PUT
    public ResponseEntity<ParticipacionEntity> updateParticipacion(@PathVariable Integer id, @RequestBody ParticipacionEntity newParticipacion) {
        ParticipacionEntity updateParticipacion = participacionService.editarParticipacion(id,newParticipacion);
        if (updateParticipacion != null) {
            return new ResponseEntity<>(updateParticipacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteParticipacion/{id}") //DELETE
    public ResponseEntity<Void> deleteParticipacion(@PathVariable Integer id) {
        participacionService.eliminarParticipacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
