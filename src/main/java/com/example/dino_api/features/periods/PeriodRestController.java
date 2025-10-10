package com.example.dino_api.features.periods;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("periods")
@RequiredArgsConstructor
public class PeriodRestController {
    
    private final PeriodsService PeriodsService;
    //podemos asignar un error especifico dando un mejor manejo de errores usando el Response Entity algo diferente a lo que hemos echo con dinosaurs que lo dejamos igual; 
    //Esto de ResponseEntity lo haremos en todo;
    @GetMapping
    public ResponseEntity<List<PeriodViewDTO>> list() throws ResponseStatusException{
        List<PeriodViewDTO> list = PeriodsService.getAllPeriods();
        if (list.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"No data");
        }
        return ResponseEntity.ok(list);
    }
    @GetMapping("{id}")
    public ResponseEntity<PeriodViewDTO> getById(@PathVariable Long id){
        
        try {
            return ResponseEntity.ok(PeriodsService.getPeriodsById(id));
        } catch (Exception e) {
            
            //Mandamos un vacio 
          throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No data");
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PeriodViewDTO> insertPeriod(@Valid @RequestBody PeriodWriteDTO periods){
        
        try {
            return ResponseEntity.ok(PeriodsService.addPeriods(periods));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<PeriodViewDTO> updateHabit(@RequestBody PeriodWriteDTO Periods){
        
        try {
            return ResponseEntity.ok(PeriodsService.updatePerids(Periods));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id){
        try {
            PeriodsService.deletePeridsById(id);
            return ResponseEntity.ok(String.format("Period delete with id: %d", id)); 
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
