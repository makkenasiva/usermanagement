package com.learn.usermanagement.userdetailsapi;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserDetails {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   private String firstname;
   private String username;
   private String user_password;
   private String status;
   private String email;
   private Integer details;
   private String institution_name;
   private String role_name;
}
