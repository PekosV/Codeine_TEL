package com.example.telproject.database.repositories;

import com.example.telproject.database.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT s.username FROM User s where s.username = ':username'")
    String findUserByUsername(@Param("username") String username);

    @Query("SELECT s.email  FROM User s where s.email   = ':email'")
    String findUserByEmail(@Param("email") String email);

}
