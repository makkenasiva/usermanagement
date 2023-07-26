package com.learn.usermanagement.getroleapi;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Role {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String roleName;

        // Constructors, getters, and setters
    }

