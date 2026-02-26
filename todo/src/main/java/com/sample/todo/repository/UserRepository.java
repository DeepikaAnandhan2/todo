package com.sample.todo.repository;

import com.sample.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //🔹 1️⃣ What this method findByEmail does
    //
    //Spring Data JPA automatically implements this method for you!
    //
    //It looks for a User entity where the email field matches the argument.
    //
    //Returns an Optional<User>:
    //
    //If a user is found → Optional contains the user
    //
    //If no user → Optional is empty
    Optional<User> findByEmail(String email);

}
