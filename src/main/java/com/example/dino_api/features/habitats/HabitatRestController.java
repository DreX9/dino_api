package com.example.dino_api.features.habitats;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("habitats")
@RequiredArgsConstructor
public class HabitatRestController {
    //lee los errores HTTP son varios 
    // Esto mismo se hace para el post o para el put, peudes gestionar que los errrores 500 no manden toda la informacion ya que un atacante al ver el error 500 que le llega en javascrip y como ese error es gigante especificando lo que ahi en la tabla o no puede darse la idea de como esta estructurarda tu base de datos, para estos casos solamentes se maquilla se dice contacta con el adm
    //leugo en otras seciones posteriores se haran un control de escepciones personalzadas 

    private final HabitatService HabitatsService;
    @GetMapping
    public ResponseEntity<List<Habitats>> list(){
        try {
            return new ResponseEntity<>(HabitatsService.getAllHabitats(), HttpStatus.OK);

        } catch (Exception e) {
            // con esta opcion le mandas un objeto vacio y le mandas tu opcion 
            //return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

            /*Cuanod hacemos esto nos lanza el mensaje pero lo que pasa es que cuando lo haces en el postmant te lanza un trace el cual tiene toda la información del progrma el paquete, ubicacion, nombre de la aplicacion, clase, metodos, quien lo invoca desde que linea */
            //este es un lanzamiento de escepciones 
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
            //cualquiera de esto es valida
        }
    }
    //todo ejemplo de lista de todo sin el response entity
    // @GetMapping
    // public List<Habitats> list(){
    //     return HabitatsService.getAllHabitats();
    // }


    //todo ejemplo antes de los cambios 
    // @GetMapping("{id}")
    // public Habitats getById(@PathVariable Long id){
    //     // cuando no devuelve nada nos dara una excepcion osea un status 500 eso es por que tu ya lo configuraste asi en el service recuerdas con Elseorthorw asi que para que esto no pase se le hara un try catch return HabitatsService.getHabitatsById(id);
    //     try {
    //         return HabitatsService.getHabitatsById(id);
    //     } catch (Exception e) {
    //         //solucion momentania si no ahi un dinosaurio me devuelve todo en blanco luego puede hacer que te devuelva un dato como mensaje o se puede omodificar el calor de cada atrubuto que segun lo que reciba muestre uno o otra cosa
    //        return new Habitats();
    //     }
    // }

    @GetMapping("{id}")
    public ResponseEntity<Habitats> getById(@PathVariable Long id){
        // cuando no devuelve nada nos dara una excepcion osea un status 500 eso es por que tu ya lo configuraste asi en el service recuerdas con Elseorthorw asi que para que esto no pase se le hara un try catch return HabitatsService.getHabitatsById(id);
        try {
            return new ResponseEntity<>(HabitatsService.getHabitatsById(id), HttpStatus.OK);
        } catch (Exception e) {
            //solucion momentania si no ahi un dinosaurio me devuelve todo en blanco luego puede hacer que te devuelva un dato como mensaje o se puede omodificar el calor de cada atrubuto que segun lo que reciba muestre uno o otra cosa
           
           //no de devuleve el mensaje que le asigne 
            //return ResponseEntity.badRequest().body(null);

            // mas elegante con el 404 eso me manda
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Habitats> insertHabit(@RequestBody Habitats Habitats){
        // Model atribute por que vamos a inserta un cuerpo 
        try {
            // el status crated devuelve un 201 que se creo 
            return new ResponseEntity<>(HabitatsService.addHabitats(Habitats), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //solucion momentania si no ahi un dinosaurio me devuelve todo en blanco luego puede hacer que te devuelva un dato como mensaje o se puede omodificar el calor de cada atrubuto que segun lo que reciba muestre uno o otra cosa
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
    //todo sin el los ResponsiEntity
    // @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    // public Habitats insertHabit(@RequestBody Habitats Habitats){
    //     // Model atribute por que vamos a inserta un cuerpo 
    //     try {
    //         return HabitatsService.addHabitats(Habitats);
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //         //solucion momentania si no ahi un dinosaurio me devuelve todo en blanco luego puede hacer que te devuelva un dato como mensaje o se puede omodificar el calor de cada atrubuto que segun lo que reciba muestre uno o otra cosa
    //        return new Habitats();
    //     }
    // }



    // @PostMapping()
    // public Habitats insertDino(@ModelAttribute Habitats Habitats){
    //     // Model atribute por que vamos a inserta un cuerpo 
    //     try {
    //         return HabitatsService.addHabitats(Habitats);
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //         //solucion momentania si no ahi un dinosaurio me devuelve todo en blanco luego puede hacer que te devuelva un dato como mensaje o se puede omodificar el calor de cada atrubuto que segun lo que reciba muestre uno o otra cosa
    //        return new Habitats();
    //     }
    // }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Habitats> updateHabit(@RequestBody Habitats Habitats){
        // Model atribute por que vamos a inserta un cuerpo 
        try {
            return new ResponseEntity<>(HabitatsService.addHabitats(Habitats), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //solucion momentania si no ahi un dinosaurio me devuelve todo en blanco luego puede hacer que te devuelva un dato como mensaje o se puede omodificar el calor de cada atrubuto que segun lo que reciba muestre uno o otra cosa
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }


    //todo Antes del ResponsiEntity
    //  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    // public Habitats updateHabit(@RequestBody Habitats Habitats){
    //     // Model atribute por que vamos a inserta un cuerpo 
    //     try {
    //         return HabitatsService.addHabitats(Habitats);
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //         //solucion momentania si no ahi un dinosaurio me devuelve todo en blanco luego puede hacer que te devuelva un dato como mensaje o se puede omodificar el calor de cada atrubuto que segun lo que reciba muestre uno o otra cosa
    //        return new Habitats();
    //     }
    // }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteHabit(@PathVariable Long id){
        // Model atribute por que vamos a inserta un cuerpo 
        try {
            return new ResponseEntity<>(HabitatsService.deleteDinosaurById(id), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //solucion momentania si no ahi un dinosaurio me devuelve todo en blanco luego puede hacer que te devuelva un dato como mensaje o se puede omodificar el calor de cada atrubuto que segun lo que reciba muestre uno o otra cosa
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }


    //todo sin ResponsiEntity
    // @DeleteMapping("{id}")
    // public String deleteHabit(@PathVariable Long id){
    //     // Model atribute por que vamos a inserta un cuerpo 
    //     try {
    //         return HabitatsService.deleteDinosaurById(id);
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //         //solucion momentania si no ahi un dinosaurio me devuelve todo en blanco luego puede hacer que te devuelva un dato como mensaje o se puede omodificar el calor de cada atrubuto que segun lo que reciba muestre uno o otra cosa
    //        return e.getMessage();
    //     }
    // }
    
}
