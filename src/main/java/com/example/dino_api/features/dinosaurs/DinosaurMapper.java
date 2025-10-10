package com.example.dino_api.features.dinosaurs;



import org.springframework.stereotype.Component;

import com.example.dino_api.common.MapperInterface;
import com.example.dino_api.features.habitats.Habitats;

//Usaremos el builder para aplicar toda la logica pero como sabes este builder tiene que aplicarse en la calse de Dinosaur pero aqui entra el lombok donde nos acorta todo esto solo colocamos @Builder en la clase.
/*para que funcione el builder tienes que colocarle 
@Builder
@AllArgsConstructor

*/



//QUIERES tRABAJAR CON una interfaz entonces usa el @Component
@Component
public class DinosaurMapper implements MapperInterface<Dinosaurs, DinosaurWriteDTO, DinosaurViewDTO>{
public Dinosaurs toEntity(DinosaurWriteDTO dto){
    return Dinosaurs.builder()
    .id(dto.id())
    .code(dto.code())
    .commonName(dto.commonName())
    .scientificName(dto.scientificName())
    .habitats(Habitats.builder().id(dto.habitatId()).build()) //esto lo dejaremos en null por que no tenemos el objeto habitat en el dto solo tenemos el id
    //Nos permitira convertir los numeros en entidades Esto lo estaba haciendo 
    .length(dto.length())
    .height(dto.height())
    .weight(dto.weight())
    .build();
}
    public DinosaurViewDTO toDt(Dinosaurs dinosaur){
        return new DinosaurViewDTO(
            dinosaur.getId(),
            dinosaur.getCode(),
            dinosaur.getScientificName(),
            dinosaur.getCommonName(),
            dinosaur.getHabitats().getRegion(), //aqui devolvemos el nombre del habitat
            dinosaur.getHabitats().getId(), //aqui devolvemos el id del habitat
            dinosaur.getLength(),
            dinosaur.getHeight(),
            dinosaur.getWeight()
        );
    }
}
