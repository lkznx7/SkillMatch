package com.lkznx7.userservice.entities.repository;

import com.lkznx7.userservice.entities.User;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    User save(User user);
}
