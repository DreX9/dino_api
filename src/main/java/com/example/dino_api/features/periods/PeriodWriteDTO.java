package com.example.dino_api.features.periods;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;


public record PeriodWriteDTO(
        Long id,
        @NotBlank(message = "No debe estar vacio") @Size(max = 100) @JsonProperty("name") String name,
        @NotNull(message = "No debe estar vacio") @Positive  Integer startsMillonsYears,
        @NotNull(message = "No debe estar vacio") @PositiveOrZero  Integer endsMillorsYears ,
        @NotBlank @Size(min = 2, max = 30) String eon,
        @NotBlank @Size(min = 2, max = 30) String era)
        {

}
 
