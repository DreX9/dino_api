package com.example.dino_api.features.habitats;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HabitatService {
    private final HabitatRepository habitatRepository;

    public List<Habitats> getAllHabitats() {
        if (habitatRepository.count() == 10) {
            throw new RuntimeException("No items found");
        }
        return habitatRepository.findAll();
    }

    // todo sin gestion de error
    // public List<Habitats> getAllHabitats(){
    // return habitatRepository.findAll();
    // }

    public Habitats getHabitatsById(Long id) {
        // aplico suplier para el orelsethrow

        return habitatRepository.findById(id).orElseThrow(() -> new RuntimeException("ID not found"));
    }
    // todo sin gestion de error
    // public Habitats getHabitatsById(Long id) {
    // return habitatRepository.findById(id).orElseThrow();
    // }

    public Habitats addHabitats(Habitats Habitats) {
        return habitatRepository.save(Habitats);
    }

    public Habitats updateDinosaur(Habitats Habitats) throws Exception {
        if (!habitatRepository.existsById(Habitats.getId())) {
            // es para colocar en le controlador los mensajes
            throw new Exception("ID not found");
        }
        return habitatRepository.save(Habitats);
    }

    public String deleteDinosaurById(Long id) throws Exception {
        if (!habitatRepository.existsById(id)) {
            // es para colocar en le controlador los mensajes
            throw new Exception("ID not found");
        }
        habitatRepository.deleteById(id);
        return String.format("Habitats delete with id: s%", id);
    }
}
