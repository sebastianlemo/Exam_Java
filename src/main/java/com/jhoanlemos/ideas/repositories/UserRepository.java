package com.jhoanlemos.ideas.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jhoanlemos.ideas.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

}
