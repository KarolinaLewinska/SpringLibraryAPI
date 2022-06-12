package com.springdemo.library.service;

import com.springdemo.library.dao.BookDao;
import com.springdemo.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    private final BookDao bookDao;

    @Autowired
    public BookService(@Qualifier("InMemory") BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    public Optional<Book> getBookById(UUID id) {
        return bookDao.getBookById(id);
    }

    public Book addBook(Book book) {
        return bookDao.insertBook(book);
    }

    public Optional<Book> updateBook(UUID id, Book newBook) {
        return bookDao.updateBookById(id, newBook);
    }

    public void deleteBookById(UUID id) {
        bookDao.deleteBookById(id);
    }
}
