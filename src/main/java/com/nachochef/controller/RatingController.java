package com.nachochef.controller;

import com.nachochef.domain.Rating;
import com.nachochef.repo.RatingRepository;
import com.nachochef.request.RatingSaveRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import javax.validation.Valid;

@ExecuteOn(TaskExecutors.IO)
@Controller("/ratings")
public class RatingController {
    private final RatingRepository ratingRepository;

    public RatingController(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Get("/info")
    @Produces(MediaType.APPLICATION_JSON)
    public Rating getSingleRating(@QueryValue int bookId) {
        return ratingRepository.findById(bookId).orElse(null);
    }

    @Post("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Rating create(@Body @Valid RatingSaveRequest ratingSaveRequest) {
        return ratingRepository.save(ratingSaveRequest.asRating());
    }
}
