package com.springdemo.library.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.UUID;

public class Book {
    private UUID id;

    @NotBlank
    private String title;
    @NotBlank
    private String author;
    @NotBlank
    private String publisher;
    @NotBlank
    private LocalDate yearOfRelease;
    @NotBlank
    private Boolean isAvailable;

    public Book(@JsonProperty("id") UUID id,
                @JsonProperty("title")String title,
                @JsonProperty("author") String author,
                @JsonProperty("publisher") String publisher,
                @JsonProperty("yearOfRelease") LocalDate yearOfRelease,
                @JsonProperty("isAvailable") Boolean isAvailable) {
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

    public Boolean getIsAvailable() {
        return isAvailable;
    }
}
