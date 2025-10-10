package com.example.dino_api.features.dinosaurs;

import org.springframework.data.jpa.repository.JpaRepository;

//No trabaja con DTO solo trabaja con la clase que solucion le damos crearemos una clase adicionamal para mapear. 
public interface DinosaursRepository extends JpaRepository<Dinosaurs, Long>{

}
