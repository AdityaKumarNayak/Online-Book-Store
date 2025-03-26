package com.aditya.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;
import com.aditya.dao.BookRepository;
import com.aditya.entities.Book;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        logger.info("Saving new book: {}", book);
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        logger.info("Retrieving all books from the database.");
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        logger.info("Fetching book with ID: {}", id);
        return bookRepository.findById(id);
    }

    public Book updateBook(Long id, Book bookDetails) {
        logger.info("Updating book with ID: {}", id);
        bookDetails.setId(id);
        return bookRepository.save(bookDetails);
    }

    public void deleteBook(Long id) {
        logger.info("Deleting book with ID: {}", id);
        bookRepository.deleteById(id);
    }
}
