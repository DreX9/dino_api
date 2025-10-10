package com.example.dino_api.features.periods;

import org.springframework.stereotype.Component;

import com.example.dino_api.common.MapperInterface;

//Usaremos el builder para aplicar toda la logica pero como sabes este builder tiene que aplicarse en la calse de Dinosaur pero aqui entra el lombok donde nos acorta todo esto solo colocamos @Builder en la clase.
/*para que funcione el builder tienes que colocarle 
@Builder
@AllArgsConstructor

*/



@Component
public class PeriodMapper implements MapperInterface<Periods, PeriodWriteDTO, PeriodViewDTO>{
public  Periods toEntity(PeriodWriteDTO dto){
    return Periods.builder()
    .id(dto.id())
    .name(dto.name())
    .startsMillonsYears(dto.startsMillonsYears())
    .endsMillorsYears(dto.endsMillorsYears())
    .eon(dto.eon())
    .era(dto.era())
    .build();
}
    public  PeriodViewDTO toDt(Periods periods){
        return new PeriodViewDTO(
            periods.getId(),
            periods.getName(),
            periods.getStartsMillonsYears(),
            periods.getEndsMillorsYears(),
            periods.getEon(),
            periods.getEra()
        );
    }
}
