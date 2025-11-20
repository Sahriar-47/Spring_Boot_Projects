package com.example.service.impl;

import com.example.entity.Book;
import com.example.repository.BookRepository;
import com.example.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    private final BookRepository bookRepository;
    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @CachePut(value="books", key="#result.id")
    @Override
    public Book createBook(Book book) {
        log.info("createBook : {}", book.getTitle());
        return bookRepository.save(book);
    }

    @CachePut(value="books", key="#id")
    @Override
    public Book updateBook(Long id, Book book) {
        log.info("updateBook : {}", book.getTitle());
        Book bookDetails = bookRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Book not found"));
        bookDetails.setTitle(book.getTitle());
        bookDetails.setAuthor(book.getAuthor());
        return bookRepository.save(bookDetails);
    }

    @Cacheable(value="books", key="#id")
    @Override
    public Book getBookById(Long id) {
        log.info("getBookById : {}", id);
        return bookRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("book not found"));
    }

    @CacheEvict(value="books", allEntries=true, key="#id")
    @Override
    public void deleteBookById(Long id) {
        log.info("deleteBookById : {}", id);
        bookRepository.deleteById(id);
    }
}
