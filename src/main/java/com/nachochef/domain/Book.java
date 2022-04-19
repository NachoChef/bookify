package com.nachochef.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.AUTO;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @NotNull
    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    // I guess this could be ManyToOne
    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "date_published", nullable = false)
    private String datePublished;

    /**
     * For creating new books (no id)
     */
    public Book(@NotNull String isbn, @NotNull String title, @NotNull String author, @NotNull String genre, @NotNull String datePublished) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.datePublished = datePublished;
    }
}
