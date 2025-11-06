package com.example.dino_api.features.usersroles;

import com.example.dino_api.features.roles.Roles;
import com.example.dino_api.features.users.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_roles_id")
    private Long id;
    @ManyToOne 
    @JoinColumn(name = "users_id", nullable = false)
    private Users users;
    @ManyToOne 
    @JoinColumn(name = "roles_id", nullable = false)
    private Roles roles;
}
