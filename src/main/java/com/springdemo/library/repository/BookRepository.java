package com.springdemo.library.repository;

import com.springdemo.library.dao.BookDao;
import com.springdemo.library.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("bookDao")
public class BookRepository implements BookDao {
    private static List<Book> booksDb = new ArrayList<>();

    @Override
    public List<Book> getAllBooks() {
        return booksDb;
    }

    @Override
    public Optional<Book> getBookById(UUID id) {
        return booksDb.stream().filter(book -> book.getId().equals(id)).findAny();
    }

    @Override
    public Book insertBook(UUID id, Book book) {
        booksDb.add(new Book(id, book.getTitle(), book.getAuthor(), book.getPublisher(),
                book.getYearOfRelease(), book.getIsAvailable()));
        return book;
    }

    @Override
    public Optional<Book> updateBookById(UUID id, Book book) {
        Optional<Book> bookToUpdate = getBookById(id);
        if (bookToUpdate.isPresent()) {
            bookToUpdate.map(bookStreamed -> {
                int bookIndex = booksDb.indexOf(bookStreamed);
                if (bookIndex >= 0) {
                    booksDb.set(bookIndex, new Book(id, book.getTitle(), book.getAuthor(),
                            book.getPublisher(), book.getYearOfRelease(), book.getIsAvailable()));

                }
                return Optional.empty();
            });
        }
        return Optional.of(book);
    }

    @Override
    public void deleteBookById(UUID id) {
        Optional<Book> bookToDelete = getBookById(id);
        if (bookToDelete.isPresent()) {
            booksDb.remove(bookToDelete.get());
        }
    }
}