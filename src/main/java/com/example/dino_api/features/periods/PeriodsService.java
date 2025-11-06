package com.example.dino_api.features.periods;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PeriodsService {
    private final PeriodsRepository repository;
    private final PeriodMapper periodMapper;

    public List<PeriodViewDTO> getAllPeriods() {
     
        return repository.findAll().stream().map(periodMapper::toDt).toList();
    }

    public PeriodViewDTO getPeriodsById(Long id) {
        return periodMapper.toDt(repository.findById(id).orElseThrow());
    }

    //suficiente con un transaccional 
    // si no quieres que se ejecute cuando se cumple con una determinada excepcion se lanzas una excepciop
    //automaticamente hace rolbag sino lo haces destro del cuerpo tambien se va a lanzar un rolbag
    @Transactional
    public PeriodViewDTO addPeriods(PeriodWriteDTO Periods) {
        return save(Periods);
    }
    //tienes dos formas de errores esta es la mas recomendada
    @Transactional
    public PeriodViewDTO updatePerids(PeriodWriteDTO Periods)  {
        if (!repository.existsById(Periods.id())) {
           //Excepcion mas adecuada para este caso mira tu notion, para entender o profundizar mas.
            throw new IllegalStateException("Id no encotrado"); 
        }
       
        return save(Periods);
    }
    // @Transactional
    // public PeriodViewDTO updatePerids(PeriodWriteDTO Periods) throws Exception {
    //     if (!repository.existsById(Periods.id())) {
    //         // es para colocar en le controlador los mensajes
    //         throw new Exception("ID not found");
    //     }
       
    //     return save(Periods);
    // }

    private PeriodViewDTO save(PeriodWriteDTO Periods) {
         return periodMapper.toDt(repository.save(periodMapper.toEntity(Periods)));
    }

    @Transactional
    public void deletePeridsById(Long id)  {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("ID not found"+ (id));
        }
        
    }
}
