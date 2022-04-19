package com.nachochef.repo;

import com.nachochef.domain.Book;
import io.micronaut.runtime.ApplicationConfiguration;
import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.inject.Singleton;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Singleton
public class BookRepository {
    private final EntityManager entityManager;
    private final ApplicationConfiguration applicationConfiguration;

    public BookRepository(EntityManager entityManager,
                               ApplicationConfiguration applicationConfiguration) {
        this.entityManager = entityManager;
        this.applicationConfiguration = applicationConfiguration;
    }

    @Transactional
    public Book save(@NotBlank String isbn, @NotBlank String title, @NotBlank String author, @NotBlank String genre, @NotBlank String datePublished) {
        Book b = new Book(isbn, title, author, genre, datePublished);
        entityManager.persist(b);
        return b;
    }

    @ReadOnly
    public List<Book> findAll(@NotBlank String author) {
        String qlString = "select b from books as b where author = :author";
        TypedQuery<Book> query = entityManager.createQuery(qlString, Book.class);

        return query.getResultList();
    }

    @Transactional
    public int update(long id, @NotBlank String name) {
        return entityManager.createQuery("UPDATE Genre g SET name = :name where id = :id")
                .setParameter("name", name)
                .setParameter("id", id)
                .executeUpdate();
    }
}
