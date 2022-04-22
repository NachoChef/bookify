package com.nachochef.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.AUTO;

@Getter
@AllArgsConstructor
@ToString
@Entity
@Table(name="ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @NotNull
    @Column(name = "user_id", nullable = false)
    private String userId;

    @NotNull
    @Column(name = "book_id", nullable = false)
    private String bookId;

    @NotNull
    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "date_created", nullable = false)
    private String dateCreated;

    /**
     * For new ratings without an id
     */
    public Rating(String userId, String bookId, int rating, String dateCreated) {
        this.userId = userId;
        this.bookId = bookId;
        this.rating = rating;
        this.dateCreated = dateCreated;
    }
}
