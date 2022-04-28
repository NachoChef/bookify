package com.nachochef.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.AUTO;

@Getter
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private AggregateRating rating;

    @Column(name = "date_created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateCreated;

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

    @PrePersist
    void preInsert() {
        if (this.dateCreated == null)
            this.dateCreated = LocalDateTime.now();;
    }
}
