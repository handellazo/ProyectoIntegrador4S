package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.dto.ConvenioDto;
import pe.edu.upeu.proyInt.entity.ConvenioEntity;
import pe.edu.upeu.proyInt.service.ConvenioService;

import java.util.List;

@RestController
@RequestMapping("/api/CONVENIO")
@CrossOrigin(origins = {"http://localhost:4200, http://localhost:8080 "})
public class ConvenioController {
    @Autowired
    private ConvenioService convenioService;

    @GetMapping("/listConvenio") //GET
    public ResponseEntity<List<ConvenioEntity>> listaConvenios(){
        List<ConvenioEntity> convenios = convenioService.convenioListar();
        return new ResponseEntity<>(convenios, HttpStatus.OK);
    };

    @PostMapping("/addConvenio") //POST
    public ResponseEntity<ConvenioEntity> crearConvenio(@RequestBody ConvenioDto convenio) {
        ConvenioEntity newConvenio = convenioService.guardarConvenio(convenio);
        if (newConvenio != null) {
            return new ResponseEntity<>(newConvenio, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/buscarConvenioPorId/{id}") //GET
    public ResponseEntity<ConvenioEntity> buscarConvenioPorId(@PathVariable Integer id){
        ConvenioEntity convenio = convenioService.buscarConvenioPorId(id);
        return new ResponseEntity<>(convenio, HttpStatus.OK);
    }

    @PutMapping("/updateConvenio/{id}") //PUT
    public ResponseEntity<ConvenioEntity> updateConvenio(@PathVariable Integer id, @RequestBody ConvenioDto newConvenio) {
        ConvenioEntity updateConvenio = convenioService.editarConvenio(id,newConvenio);
        if (updateConvenio != null) {
            return new ResponseEntity<>(updateConvenio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteConvenio/{id}") //DELETE
    public ResponseEntity<Void> deleteConvenio(@PathVariable Integer id) {
        convenioService.eliminarConvenio(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
