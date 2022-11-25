package az.spring.service;

import az.spring.entity.Book;

import java.util.List;

public interface BookService {
    Book  save(Book book);

    Book update(Book book,Long id);

    void delete(Long id);

    List<Book> getAllBooks();
}
