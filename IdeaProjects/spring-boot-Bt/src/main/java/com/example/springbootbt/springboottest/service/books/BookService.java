package com.example.springbootbt.springboottest.service.books;

import com.example.springbootbt.springboottest.model.Book;
import com.example.springbootbt.springboottest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBooksService {

@Autowired
    private BookRepository bookRepository;



    @Override
    public List<Book> findAll() {
        if (bookRepository == null) {
            throw new IllegalStateException("BookRepository chưa được khởi tạo (null)");
        }
        return bookRepository.findAll();
    }
    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void remove(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }
}
