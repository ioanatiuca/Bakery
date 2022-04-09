package com.bakery.finalproject.repository;

import com.bakery.finalproject.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID>{
    @Query("Select c from Client c where c.email = :email")
    Optional<Client> findByEmail(@Param("email") String email);
}
