package com.example.dino_api.features.users;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UsersRepository usersRepository;

    public Users getUsersById(Long id) {

        return usersRepository.findById(id).orElseThrow(() -> new RuntimeException("User ID not found"));
    }

     public Users getUsersByEmail(String email) {

        return usersRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User  Email not found"));
    }
}
