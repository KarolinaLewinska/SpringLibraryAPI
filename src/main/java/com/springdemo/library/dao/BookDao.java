package com.springdemo.library.dao;

import com.springdemo.library.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookDao {
    List<Book> getAllBooks();
    Optional<Book> getBookById(UUID id);

    default Book insertBook(Book book) {
        UUID id = UUID.randomUUID();
        return insertBook(id, book);
    }
    Book insertBook(UUID id, Book book);

    void deleteBookById(UUID id);
    Optional<Book> updateBookById(UUID id, Book book);
}
