package com.example.dino_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//se setea con el metodo de encriptamiento 
    @Bean
    BCryptPasswordEncoder passwordEncode(){
        //
        return new BCryptPasswordEncoder();
    }
    //filtro de seguridad
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
        .authorizeHttpRequests(
            auth -> auth.requestMatchers("/").permitAll()    //En este caos las rutas pueblicas seran EL LOCAL host ya que es el inicial no me pedira nada cuando entre pero me dire error 404 no encontrado
            .requestMatchers("/dinosaurs/**").hasAuthority("VIEWER")  // Atenticado y con administrador
            .requestMatchers("/periods/**").hasAuthority("USER")  // Atenticado y con administrador
            .requestMatchers("/habitats/**").hasAnyAuthority("ADMIN, USER") //ESE hasAnyAuthority nos indica que a este recurso pueden ascceder tanto admin como user 
            .anyRequest().authenticated()  //Solo autenticado
        ).httpBasic(Customizer.withDefaults()) //Cuando queramos invocar cualquiera de estos meotod nos va a aprecer esa ventana de javaScript pidiendonos usuario y contraseña
        .build();
    }
}
