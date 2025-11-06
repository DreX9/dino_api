package com.example.dino_api.features.periods;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

//No trabaja con DTO solo trabaja con la clase que solucion le damos crearemos una clase adicionamal para mapear. 
public interface PeriodsRepository extends JpaRepository<Periods, Long>{
//Crea un metodo que nos devuelva los metodos por era
//Query nativo
/*Peude ser una lista de periodos esto en nuestro metodo Optional<List<Periods>> 
 * Le tenemos que pasar ese era que esta como parametro en el metodo le pasamos a nuestro query nativo
 * El objeto Periods en este caso no se vincula directamente con el query ya que es query nativo es como si lo insertaras en el sql
 * Si lo hago con lista y encaso no encuentre nada me devolvera nulo
 * si lo hago con Optinal antes de la lista me va a poder permitir colocar or else or else pro si no ahi nada o falla devuelve otro objeto o lanza una advertencia 
*/
@Query(value = "select * from periods where era = ?1", nativeQuery = true)
List<Periods> periodosPorEra(String era);
// JPQL
/*
 * Algo similar recuerda cuando no le pones el nativeQuery = true es por que por defectoesta esperando el jpql
 * El objeto Periods en este caso si se vincula directamente con el query 
 * esto :era" es para que se pueda llamar a era para ello utilizamos el argumento @Param("era") para recalcarlo 
 * Para parametros si vas a tener varios colocas @Param le colocas un alias y le colocas el alias con un : adelante 
*/
@Query(value = "select p from Periods p where p.era = :era")
List<Periods> periodosPorEraJPQL(@Param("era") String era);
// JPA (Recomendado)
//Ahi casos particulares con multiples join ahi si utlizas el JPQL que es mas recomandable para ello
List<Periods> findByEra(String era);

/*
 * Se llama al procedure en le repository 
   se coloca todo en mayusculas con _ 
   si no quieres hacerlo con esa nomenglatura y solo trabajar en pascalecase solo usas 
   si te devuelbe una lista usas el @Query y tiene que ser nativo 
 */
/*
 * DELIMITER $$

 * 
 */
@Procedure(value = "CONTAR_PERIODOS")
int contarPeriodos(String era);

}
