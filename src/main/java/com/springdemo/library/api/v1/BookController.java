package com.springdemo.library.api.v1;

import com.springdemo.library.model.Book;
import com.springdemo.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/book")
@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(path = "{id}")
    public Optional<Book> getBookById(@PathVariable("id") UUID id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public void addBook(@Valid @NonNull @RequestBody Book book) {
        bookService.addBook(book);
    }

    @PutMapping(path = "{id}")
    public void updateBook(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Book newBook) {
        bookService.updateBook(id, newBook);
    }

    @DeleteMapping(path = "{id}")
    public void deleteBookById(@PathVariable("id") UUID id) {
        bookService.deleteBookById(id);
    }
}
