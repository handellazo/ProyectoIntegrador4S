package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.dto.GrupoPyDto;
import pe.edu.upeu.proyInt.entity.GrupoPyEntity;
import pe.edu.upeu.proyInt.service.GrupoPyService;

import java.util.List;

@RestController
@RequestMapping("/api/GRUPOPY")
@CrossOrigin({"*"})
public class GrupoPyController {
    @Autowired
    private GrupoPyService grupoPyService;

    @GetMapping("/listGrupoPy") //GET
    public ResponseEntity<List<GrupoPyEntity>> listaGrupoPys(){
        List<GrupoPyEntity> grupoPys = grupoPyService.grupoPyListar();
        return new ResponseEntity<>(grupoPys, HttpStatus.OK);
    };

    @GetMapping("/buscarGrupoPyPorId/{id}") //GET
    public ResponseEntity<GrupoPyEntity> buscarGrupoPyPorId(@PathVariable Integer id){
        GrupoPyEntity grupoPy = grupoPyService.buscarGrupoPyPorId(id);
        return new ResponseEntity<>(grupoPy, HttpStatus.OK);
    }

    @PostMapping("/addGrupoPy") //POST
    public ResponseEntity<GrupoPyEntity> crearGrupoPy(@RequestBody GrupoPyDto grupoPy) {
        GrupoPyEntity newGrupoPy = grupoPyService.guardarGrupoPy(grupoPy);
        if (newGrupoPy != null) {
            return new ResponseEntity<>(newGrupoPy, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateGrupoPy/{id}") //PUT
    public ResponseEntity<GrupoPyEntity> updateGrupoPy(@PathVariable Integer id, @RequestBody GrupoPyDto newGrupoPy) {
        GrupoPyEntity updateGrupoPy = grupoPyService.editarGrupoPy(id,newGrupoPy);
        if (updateGrupoPy != null) {
            return new ResponseEntity<>(updateGrupoPy, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteGrupoPy/{id}") //DELETE
    public ResponseEntity<Void> deleteGrupoPy(@PathVariable Integer id) {
        grupoPyService.eliminarGrupoPy(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
