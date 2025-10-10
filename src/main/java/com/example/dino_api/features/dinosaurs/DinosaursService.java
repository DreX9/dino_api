package com.example.dino_api.features.dinosaurs;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DinosaursService {
    private final DinosaursRepository repository;
    /*por que hago esta inyeccion de dependencias de nuevo veras haces esto por que tu clase ya 
     * no es estatica cuando era estatica podias invocarlo sin necesidad de una inyeccion de dependencias 
     * pero como dejo de serlo entonces tienes que hacer un ainyeccion de dependencias
     * por que dejo de serlo por que estmos trabajando con un Mapper que ya no solo es una clase sino que implementa metodos de una interfaz mapper lo cual hace que no podamos colocar a sus metodos como estaticos 
     * pero con esta inyecion de dependencias si se puede
    */
    private final DinosaurMapper dinosaurMapper;

    public List<DinosaurViewDTO> getAllDinosaurs() {
        // una vez que tenemos el mapper lo usamos aqui, investigasr como o que se hace
        // el map o por que lo llama al DinosaurMapper ::toDt
        // el stream es para convertir la lista en un flujo de datos y luego con el map
        // lo que hace es aplicar la funcion a cada elemento del flujo en este caso la
        // funcion es el metodo toDt que convierte cada objeto Dinosaurs en un objeto
        // DinosaurViewDTO
        // luego con el toList lo que hace es convertir el flujo de datos en una lista
        // de nuevo
        // esto es para no devolver la entidad completa sino solo los datos que queremos
        // devolver en este caso los del DTO
        return repository.findAll().stream().map(dinosaurMapper::toDt).toList();
    }

    public DinosaurViewDTO getDinosaursById(Long id) {
        return dinosaurMapper.toDt(repository.findById(id).orElseThrow());
    }

    public DinosaurViewDTO addDinosaurs(DinosaurWriteDTO dinosaurs) {
        return save(dinosaurs);
    }

    public DinosaurViewDTO updateDinosaur(DinosaurWriteDTO dinosaurs) throws Exception {
        if (!repository.existsById(dinosaurs.id())) {
            // es para colocar en le controlador los mensajes
            throw new Exception("ID not found");
        }
        // Esta es una opcion
        // return
        // DinosaurMapper.toDt(repository.save(DinosaurMapper.toEntity(dinosaurs)));
        // Otra opcion es invocar al metod anterior y pasarle el dato
        // return addDinosaurs(dinosaurs);
        // otra manera vamos a crear un save el cual nosdara mas sentido por que miralos
        // de este lado como actualizar va a llamar a agragar
        // este era muestro metodo de addDinosaurs antes del cambio ahora se cambiara y mira como lo llamare 
        /*
         * public DinosaurViewDTO addDinosaurs(DinosaurWriteDTO dinosaurs){
         * //voya a devolver el dto que va hacer cuando guarde este Entity
         * return
         * DinosaurMapper.toDt(repository.save(DinosaurMapper.toEntity(dinosaurs)));
         * }
         */
        return save(dinosaurs);
    }

    private DinosaurViewDTO save(DinosaurWriteDTO dinosaurs) {
         return dinosaurMapper.toDt(repository.save(dinosaurMapper.toEntity(dinosaurs)));
    }

    public String deleteDinosaurById(Long id) throws Exception {
        if (!repository.existsById(id)) {
            // es para colocar en le controlador los mensajes
            throw new Exception("ID not found");
        }
        repository.deleteById(id);
        return String.format("Dinosaurs delete with id: s%", id);
    }
}
