package com.example.dino_api.features.dinosaurs;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("dinosaurs")
@RequiredArgsConstructor
public class DinosaurRestController {
    
    private final DinosaursService dinosaursService;
    @GetMapping
    public List<DinosaurViewDTO> list(){
        return dinosaursService.getAllDinosaurs();
    }
    @GetMapping("{id}")
    public DinosaurViewDTO getById(@PathVariable Long id){
        
        try {
            return dinosaursService.getDinosaursById(id);
        } catch (Exception e) {
            
            //Mandamos un vacio 
           return new DinosaurViewDTO(id, null, null, null, null, null, null, null, null);
        }
    }

    @PostMapping()
    public DinosaurViewDTO insertDino(@Valid @RequestBody DinosaurWriteDTO dinosaur){
        
        try {
            return dinosaursService.addDinosaurs(dinosaur);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //solucion momentania si no ahi un dinosaurio me devuelve todo en blanco luego puede hacer que te devuelva un dato como mensaje o se puede omodificar el calor de cada atrubuto que segun lo que reciba muestre uno o otra cosa
           return null;
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public  DinosaurViewDTO updateHabit(@RequestBody DinosaurWriteDTO dinosaurs){
        
        try {
            return dinosaursService.updateDinosaur(dinosaurs);
        } catch (Exception e) {
            return null;
        }
    }
    

    @DeleteMapping("{id}")
    public String deleteById(@PathVariable long id){
        try {
            return dinosaursService.deleteDinosaurById(id);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
