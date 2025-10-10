package com.example.dino_api.features.dinosaurs;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

// ESTE SERA MI DTO Para escribir 
//Parecodo al view pero recuerda tienes que analizar en este caso es para insertar cuando insertes o escribas que quieres el id si, code si, scientificname si, commonName si, del habitad voy a escribir su nombre no solo el id mucho mas corto ahi que verificar el id del habitad de que tipo es 
//si queremos colocar el @Notblank y no aparece es por que no agregaste el started como lo haces con el contrl + shift + p deberia aprecerte Spring Inicalizer add starters (Podremos volver a las dependencias donde agregaremos una dependencia) Selecionamos Validation I/O cone so echo ya se puede agregar el NotBlank
//lo hacemos con un patter para colocar una expresion regular algo mas elaborado que un simple @Size
public record DinosaurWriteDTO(
        Long id,
        @NotBlank @Pattern(regexp = "^C\\d{6}$") String code,
        @NotBlank @Size(max = 100) @JsonProperty("scientific_name") String scientificName,
        @NotBlank @Size(max = 100) @JsonProperty("common_name") String commonName,
        @NotNull Long habitatId,
        @NotNull @Positive BigDecimal length,
        @NotNull @Positive BigDecimal height,
        @NotNull @Positive BigDecimal weight) {

}
//echo esto ya tienes separacion de responsabilidades la clase dinosaurs solo se dedica a definir la estructura de la tabal del mapeo entidad relacion 
//view dto su finalidad es como me muestra los datos 
//write hace full validadcion para hacer escritura o inserciones para hacer full validaciones 
