package com.example.springbootbt.springboottest.service.books;

import com.example.springbootbt.springboottest.model.Book;

import java.util.List;

public interface IBooksService extends IGeneralService<Book> {
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
}
