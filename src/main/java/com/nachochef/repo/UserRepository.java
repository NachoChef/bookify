package com.nachochef.repo;

import com.nachochef.domain.User;
import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.inject.Singleton;

import javax.persistence.EntityManager;
import java.util.Optional;

@Singleton
public class UserRepository implements Repository<User> {

    private final EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @ReadOnly
    public Optional<User> findById(long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public User save(User objectToSave) {
        entityManager.persist(objectToSave);
        return objectToSave;
    }

    @Override
    public void deleteById(long id) {
        findById(id).ifPresent(entityManager::remove);
    }

    @Override
    public int update(User objectToUpdate) {
        return entityManager.createQuery("update users u set username = :username where id = :id")
                .setParameter("username", objectToUpdate.getUsername())
                .setParameter("id", objectToUpdate.getId())
                .executeUpdate();
    }
}
