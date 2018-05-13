package com.example.telproject.database.repositories;

import com.example.telproject.database.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
