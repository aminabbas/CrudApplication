package az.spring.controller;

import az.spring.entity.Book;
import az.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book,
                           @PathVariable("id") Long bookId) {
        return bookService.update(book, bookId);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBookById(@PathVariable("id") Long bookId) {
        bookService.delete(bookId);
        return "Deleted!";
    }
}
