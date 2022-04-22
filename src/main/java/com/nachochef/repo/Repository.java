package com.nachochef.repo;

import com.nachochef.domain.Book;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface Repository<T> {

    Optional<T> findById(long id);

    T save(@NotNull T objectToSave);

    T saveWithException(@NotNull T objectToSave);

    void deleteById(long id);

    int update(T objectToUpdate);
}
