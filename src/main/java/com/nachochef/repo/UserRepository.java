package com.nachochef.repo;

import com.nachochef.domain.Rating;
import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
public class UserRepository implements Repository<Rating> {
    @Override
    public Optional<Rating> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Rating save(Rating objectToSave) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public int update(Rating objectToUpdate) {
        return 0;
    }
}
