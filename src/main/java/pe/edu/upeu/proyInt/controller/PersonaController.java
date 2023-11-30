package pe.edu.upeu.proyInt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.proyInt.dto.PersonaDto;
import pe.edu.upeu.proyInt.entity.PersonaEntity;
import pe.edu.upeu.proyInt.service.PersonaService;

import java.util.List;

@RestController
@RequestMapping("/api/PERSONA")
@CrossOrigin(origins = {"http://localhost:4200, http://localhost:8080 "})
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    //Listar Personas
    @GetMapping("/listPersona") //GET @GetMapping es una anotacion para construir APIS
    public ResponseEntity<List<PersonaEntity>> listaPersonas(){
        try{
            List<PersonaEntity> personas = personaService.personaListar();
            return new ResponseEntity<>(personas, HttpStatus.OK);
        } catch (Error e){
            System.out.println("No se puede listar: " + e);
        }
        return null;
    };

    @GetMapping("/buscarPersonaPorId/{id}") //GET
    public ResponseEntity<PersonaEntity> buscarCursoporId(@PathVariable Integer id){
        PersonaEntity persona = personaService.buscarPersonaPorId(id);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    //Añadir Persona
    @PostMapping("/addPersona") //POST @PostMapping es una anotacion para construir APIS
    public ResponseEntity<PersonaEntity> crearPersona(@RequestBody PersonaDto persona) {
        PersonaEntity newPersona = personaService.guardarPersona(persona);
        if (newPersona != null) {
            return new ResponseEntity<>(newPersona, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Actuaizar Persona
    @PutMapping("/updatePersona/{id}") //PUT @PutMapping es una anotacion para construir APIS
    public ResponseEntity<PersonaEntity> updatePersona(@PathVariable Integer id, @RequestBody PersonaDto newPersona) {
        PersonaEntity updatePersona = personaService.editarPersona(id,newPersona);
        if (updatePersona != null) {
            return new ResponseEntity<>(updatePersona, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //Eliminar Persona
    @DeleteMapping("/deletePersona/{id}") //DELETE @DeleteMapping es una anotacion para construir APIS
    public ResponseEntity<Void> deletePersona(@PathVariable Integer id) {
        personaService.eliminarPersona(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
