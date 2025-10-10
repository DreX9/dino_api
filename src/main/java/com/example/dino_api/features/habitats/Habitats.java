package com.example.dino_api.features.habitats;

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
@NoArgsConstructor
@Builder //Le agregas un builder para que te cree un constructor con todos los atributos pero no solo para eso sino para poder llamar al id en el mapper en este caso en el DinosaurMapper
@AllArgsConstructor
public class Habitats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "habitat_id")
    private Long id;
    @Column(nullable = false, length = 100, unique = true)
    private String region;

}
