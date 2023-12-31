package com.learn.usermanagement.userdetailsapi;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DetailsRepository extends JpaRepository<UserDetails, Integer> {
    UserDetails findByDetails(Integer details);
}

