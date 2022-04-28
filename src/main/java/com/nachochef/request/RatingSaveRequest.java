package com.nachochef.request;

import com.nachochef.domain.Rating;
import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
@Introspected
public class RatingSaveRequest {
    @NotBlank
    private String userId;

    @NotBlank
    private String bookId;

    @NotBlank
    private int rating;

    private String ratingText;

    public Rating asRating() {
        return new Rating(userId, bookId, rating, ratingText);
    }
}
