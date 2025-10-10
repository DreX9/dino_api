package com.example.dino_api.features.periods;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Periods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50, unique = true)
    private String name;
    @Column(nullable = false, length = 30)
    private String eon;
    @Column(nullable = false, length = 30)
    private String era;
    @Column(name = "starts_million_years", nullable = false)
    private Integer startsMillonsYears;
    @Column(name = "ends_million_years", nullable = false)
    private Integer endsMillorsYears;
}
