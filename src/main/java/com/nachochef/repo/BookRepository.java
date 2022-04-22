package com.nachochef.repo;

import com.nachochef.domain.Book;
import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
public class BookRepository implements Repository<Book> {

    @Override
    public Optional<Book> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Book save(Book objectToSave) {
        return null;
    }

    @Override
    public Book saveWithException(Book objectToSave) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public int update(Book objectToUpdate) {
        return 0;
    }
}
