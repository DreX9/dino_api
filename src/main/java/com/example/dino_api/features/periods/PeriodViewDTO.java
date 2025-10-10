package com.example.dino_api.features.periods;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PeriodViewDTO(
        
        Long id,
        String name,
        @JsonProperty("starts_million_years")
        Integer startsMillonsYears,
        @JsonProperty("ends_million_years")
         Integer endsMillorsYears,
         String eon,
         String era
        ) {

}
