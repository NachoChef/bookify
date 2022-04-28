package com.nachochef.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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

    @Column(name = "rating_text")
    private String ratingText;

    @Column(name = "date_created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateCreated;

    /**
     * For new ratings without an id
     */
    public Rating(String userId, String bookId, int rating, String ratingText) {
        this.userId = userId;
        this.bookId = bookId;
        this.rating = rating;
        this.ratingText = ratingText;
    }

    @PrePersist
    void preInsert() {
        if (this.dateCreated == null)
            this.dateCreated = LocalDateTime.now();;
    }
}
