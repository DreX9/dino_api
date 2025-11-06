package com.example.dino_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.dino_api.features.users.Users;
import com.example.dino_api.features.users.UsersRepository;

@SpringBootApplication
public class DinoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DinoApiApplication.class, args);
	}

	// @Bean
	// CommandLineRunner createDefaultUsers(UsersRepository repository, PasswordEncoder encoder){
	// 	return args -> {
	// 		if (repository.findByEmail("admin@mail.com").isEmpty()) {
	// 			Users user = new Users();
	// 			user.setName("admin");
	// 			user.setEmail("admin@mail.com");
	// 			user.setPassword(encoder.encode("123456"));
	// 			user.setRoles("ADMIN");
	// 			repository.save(user);
	// 		}
	// 	}; 
	// }

}
