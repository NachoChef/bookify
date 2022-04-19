package com.nachochef.controller;

import com.nachochef.repo.BookRepository;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.QueryValue;

@Controller("/books/*")
public class BookController {
    private final BookRepository bookRepository;

    @Get("/info")
    @Produces(MediaType.APPLICATION_JSON)
    public String getBook(@QueryValue int bookId) {

    }
}
