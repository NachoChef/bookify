package com.nachochef.controller;

import com.nachochef.domain.Book;
import com.nachochef.repo.BookRepository;
import com.nachochef.request.BookSaveRequest;
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
@Controller("/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Get("/info")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBook(@QueryValue int bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    @Post("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Book create(@Body @Valid BookSaveRequest bookSaveRequest) {
        return bookRepository.save(bookSaveRequest.asBook());
    }
}
