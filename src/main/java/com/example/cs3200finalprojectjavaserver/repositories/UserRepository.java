package com.example.cs3200finalprojectjavaserver.repositories;

import com.example.cs3200finalprojectjavaserver.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("SELECT user FROM User user WHERE user.username=:username")
    User findUserByUsername(String username);
    @Query("SELECT user FROM User user WHERE user.username=:username AND user.password=:password")
    User findUserByUsernameAndPassword(String username, String password);
}