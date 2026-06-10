package com.lkznx7.userservice.infrastructure.repository;

import com.lkznx7.userservice.adapters.mappers.UserMapper;
import com.lkznx7.userservice.entities.User;
import com.lkznx7.userservice.entities.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository jpaRepository;

    public UserRepositoryImpl(UserJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepository.findByEmail(email)
                .map(UserMapper::toDomain);
    }

    @Override
    public User save(User user) {
        var entity = UserMapper.toJpaEntity(user);
        var savedEntity = jpaRepository.save(entity);
        return UserMapper.toDomain(savedEntity);
    }
}
