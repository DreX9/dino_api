package com.example.dino_api.features.dinosaurs;

import java.math.BigDecimal;

import com.example.dino_api.features.habitats.Habitats;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Dinosaurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dinosaur_id")
    private Long id;
    @Column(nullable = false, length = 100, unique = true)
    private String code;
    @Column(nullable = false, length = 100, unique = true)
    private String scientificName;
    @Column(nullable = false, length = 100, unique = true)
    private String commonName;

    @ManyToOne 
    @JoinColumn(name = "habitad_id", nullable = false)
    private Habitats habitats;
    //presicion puede tener 6 valores en total y 2 pueden ser .flotente es decir pueden llegar asta 9999.99 este seria el ejemplo
    @Column(name = "length_meters", nullable = false, precision = 6, scale = 2)
    private BigDecimal length;
    @Column(name = "height_meters", nullable = false, precision = 5, scale = 2)
    private BigDecimal height;
    @Column(name = "weight_kgs", nullable = false, precision = 8, scale = 2)
    private BigDecimal weight;
    // TU SABES QUE PODRIAS TENER MAS COSAS EN ESTAS COLUMNAS COMO UN @NOTBLANK PARA QUE NO SEA VACIO CUANDO ESCRIBRES 
    //pero que sucede al tu darle estas validaciones estas rompiendo el principio de responsabilidad unica 
    //por eso es que se creara un DTO donde se pase un objeto y ahi lo vamos a personalizar a nuestras necesidades 
    //creoamos un record new java file record

}
