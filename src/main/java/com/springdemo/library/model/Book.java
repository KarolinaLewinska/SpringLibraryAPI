package com.springdemo.library.model;

import java.time.LocalDate;
import java.util.UUID;

public class Book {
    private UUID id;
    private String title;
    private String author;
    private String publisher;
    private LocalDate yearOfRelease;
    private Boolean isAvailable;

    public Book(UUID id, String title, String author, String publisher, LocalDate yearOfRelease, Boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearOfRelease = yearOfRelease;
        this.isAvailable = isAvailable;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public LocalDate getYearOfRelease() {
        return yearOfRelease;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }
}
