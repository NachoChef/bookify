package com.nachochef.repo;

import com.nachochef.domain.Rating;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.TransactionalAdvice;
import jakarta.inject.Singleton;

import javax.persistence.EntityManager;
import java.util.Optional;

@Singleton
public class RatingRepository implements Repository<Rating> {

    private EntityManager entityManager;

    public RatingRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @ReadOnly
    public Optional<Rating> findById(long id) {
        return Optional.ofNullable(entityManager.find(Rating.class, id));
    }

    @Override
    @TransactionalAdvice
    public Rating save(Rating objectToSave) {
        entityManager.persist(objectToSave);
        return objectToSave;
    }

    @Override
    @TransactionalAdvice
    public void deleteById(long id) {
        findById(id).ifPresent(entityManager::remove);
    }

    @Override
    @TransactionalAdvice
    public int update(Rating objectToUpdate) {
        return entityManager.createQuery("update ratings r set rating = :rating where id = :id")
                .setParameter("rating", objectToUpdate.getRating())
                .setParameter("id", objectToUpdate.getId())
                .executeUpdate();
    }
}
