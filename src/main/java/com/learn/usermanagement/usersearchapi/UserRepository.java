package com.learn.usermanagement.usersearchapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByFirstname(String firstname);
    List<User> findByUsername(String username);
    List<User> findByEmail(String email);
}

