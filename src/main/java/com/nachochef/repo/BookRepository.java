package com.nachochef.repo;

import com.nachochef.domain.Book;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.TransactionalAdvice;
import jakarta.inject.Singleton;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.transaction.NotSupportedException;
import java.util.List;
import java.util.Optional;

/**
 * https://guides.micronaut.io/latest/micronaut-jpa-hibernate-gradle-java.html
 *
 * I'm loosely following this since I haven't really used micronaut or entity managers before
 */
@Singleton
public class BookRepository implements Repository<Book> {

    private final EntityManager entityManager;

    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @ReadOnly
    public Optional<Book> findById(long id) {
        return Optional.ofNullable(entityManager.find(Book.class, id));
    }

    @ReadOnly
    public List<Book> findByAuthor(String author) {
        // I assume eventually I'll want title/etc too
        return entityManager.createQuery("select * from books b where b.author = :author")
                .getResultList();
    }

    @Override
    @TransactionalAdvice
    public Book save(Book objectToSave) {
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
    public int update(Book objectToUpdate) {
        throw new PersistenceException(new NotSupportedException("Book entries are immutable."));
    }
}
