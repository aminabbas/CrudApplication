package az.spring.service;

import az.spring.entity.Book;
import az.spring.entity.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book, Long id) {
        Book bk = bookRepository.findById(id).get();
        if (Objects.nonNull(book.getName()) && !"".equalsIgnoreCase(book.getName())) {
            bk.setName(book.getName());
        }

        if (Objects.nonNull(book.getAuthor()) && !"".equalsIgnoreCase(book.getAuthor())) {
            bk.setAuthor(book.getAuthor());
        }

        if (Objects.nonNull(book.getPublishYear()) && !"".equalsIgnoreCase(book.getPublishYear())) {
            bk.setPublishYear(book.getPublishYear());
        }

        return bookRepository.save(bk);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }



    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }
}
