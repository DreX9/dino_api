package com.example.dino_api.features.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersRepository extends JpaRepository<Users, Long>{
    Optional<Users> findByEmail(String email);
    
}
