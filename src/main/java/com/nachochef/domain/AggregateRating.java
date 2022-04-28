package com.nachochef.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="book_aggregate_ratings")
public class AggregateRating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "book_id")
    private int bookId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "calculated_rating")
    private double calculatedRating;

    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateCreated;
}
