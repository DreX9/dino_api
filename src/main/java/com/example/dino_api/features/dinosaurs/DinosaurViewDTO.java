package com.example.dino_api.features.dinosaurs;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;



// los record son inmutables (no necesita set y get al ser inmutable tiene un solo tipo de contructor por defecto)
// nos servira para leer 
//todos los datos seran dentro del parentesis en este caso los datos serian los del Dinasaurs 
//tip de programacion un simple copia y pega de los atributos  sin el private
/*
 * Colocamos primero al inicio de los private seleccionandolos presionas contrl mas f2 y se seleccionan todos los private en este caso todo lo que ser repite luego te despalzaras ata el tipo y variable que serian Long id, con el contrl shift y la tecla de flecha derecha seleccinas y se seleccionaran todos  
 */

 /*en este view dto mi pricipal diferencia sera esto 
    @ManyToOne 
    @JoinColumn(name = "habitad_id", nullable = false)
    private Habitats habitats;
    En lugar de devolver un objeto yo devolcere el nombre del habitat  o asta el id podria devolver por eso es que ya no seria un objeto sino un string 
    Hace mas facil el recibir datos que un objeto completo 
 
 */ 
public record DinosaurViewDTO(
        //Si quieres colocarle un formato de nomanglatura como en json que es un snake case se podria pero no necsitas cambiar todo parsa igual que con los @column pero este ves con un @JsonProperty("") para que me devuelva en ese formato de snake case, se peude hacer lo mismo eso si obiamente vamos a enviar los datos con los nombres que estan en este formato claro siempre y cuando se aplique a tru writer dto 
        Long id,
        String code,
        @JsonProperty("scientific_name")
        String scientificName,
                @JsonProperty("common_name")

        String commonName,
                @JsonProperty("habitats_region")

        String habitatsRegion,
        //si colocaste en tu habitats el builder podras llamar al id del habitat
        //si no lo colocaste te dara error
        //si en tu habitad tu id esta con long lo colocas con long si esta con int lo colocas con int 
        //si en tu habitad tu id esta con Long lo colocas con Long si esta con Integer lo colocas con Integer sino te dara error
        Long habitatsId,
        BigDecimal length,
        BigDecimal height,
        BigDecimal weight) {

}
