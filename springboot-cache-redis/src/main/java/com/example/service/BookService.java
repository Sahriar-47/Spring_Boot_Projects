package com.example.service;

import com.example.entity.Book;

public interface BookService {
    Book createBook(Book book);
    Book updateBook(Long id, Book book);
    Book getBookById(Long id);
    void deleteBookById(Long id);
}
