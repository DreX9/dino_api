package com.example.dino_api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dino_api.features.periods.Periods;
import com.example.dino_api.features.periods.PeriodsRepository;
//La razon de colcar el @SpringBootTest es que los repository los llama el service por eso no ahi necesidad de Colocar DataJPATest
@SpringBootTest
public class PeriodsRepositoryTest {
    @Autowired
    PeriodsRepository repository;
    
    @Test
    public void testNativeQuery(){
        List<Periods> periodos = repository.periodosPorEra("Cenozoico");
        assertEquals(periodos.size(), 1);

    }
    @Test
    public void testJPQLQuery(){
        List<Periods> periodos = repository.periodosPorEraJPQL("Cenozoico");
        assertEquals(periodos.size(), 1);
    }
    @Test
    public void testJPAQuery(){
        List<Periods> periodos = repository.findByEra("Cenozoico");
        assertEquals(periodos.size(), 1);
    }

    @Test
    public void contador(){
        int c = repository.contarPeriodos("Cenozoico");
        assertEquals(c,1);
    }


}
