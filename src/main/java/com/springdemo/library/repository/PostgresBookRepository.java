package com.springdemo.library.repository;

import com.springdemo.library.dao.BookDao;
import com.springdemo.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("Postgres")
public class PostgresBookRepository implements BookDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresBookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> getAllBooks() {
        final String selectQuery = "SELECT * FROM books";
        List<Book> books = jdbcTemplate.query(selectQuery, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String publisher = resultSet.getString("publisher");
            Date yearOfRelease = resultSet.getDate("yearofrelease");
            Boolean isAvailable = resultSet.getBoolean("isavailable");

            return new Book(id,title, author, publisher, yearOfRelease, isAvailable);
        });
        return books;
    }

    @Override
    public Optional<Book> getBookById(UUID id) {
        final String selectQuery = "SELECT * FROM books WHERE id = ?";
        Book selectedBook = jdbcTemplate.queryForObject(selectQuery, new Object[]{id},
                (resultSet, i) -> {
                UUID bookId = UUID.fromString(resultSet.getString("id"));
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String publisher = resultSet.getString("publisher");
                Date yearOfRelease = resultSet.getDate("yearofrelease");
                Boolean isAvailable = resultSet.getBoolean("isavailable");
                return new Book(bookId,title, author, publisher, yearOfRelease, isAvailable);
            });
        return Optional.ofNullable(selectedBook);
    }

    @Override
    public Book insertBook(UUID id, Book book) {
        final String insertQuery = "INSERT INTO books (id, title, author, publisher, yearofrelease, isavailable) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(insertQuery, id, book.getTitle(), book.getAuthor(), book.getPublisher(),
                book.getYearOfRelease(), book.getIsAvailable());
        return book;
    }

    @Override
    public Optional<Book> updateBookById(UUID id, Book book) {
        final String updateQuery = "UPDATE books set title = ?, author = ?, publisher = ?, yearofrelease = ?, isavailable = ? WHERE id = ?";
        jdbcTemplate.update(updateQuery,book.getTitle(), book.getAuthor(), book.getPublisher(),
                book.getYearOfRelease(), book.getIsAvailable(), id);
        return Optional.of(book);
    }

    @Override
    public void deleteBookById(UUID id) {
        final String deleteQuery = "DELETE books WHERE id = ?";
        jdbcTemplate.update(deleteQuery, id);
    }
}