package com.nachochef.request;


import com.nachochef.domain.Book;
import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
@Introspected
public class BookSaveRequest {
    @NotBlank
    private String isbn;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotBlank
    private String genre;

    @NotBlank
    private String datePublished;

    public Book asBook() {
        return new Book(isbn, title, author, genre, datePublished);
    }
}
