package com.aditya.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.aditya.dao.BookRepository;
import com.aditya.entities.Book;

@SpringBootTest
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        book1 = new Book(1L, "Book One", "Author One", new BigDecimal(500), LocalDate.of(2023, 1, 1));
        book2 = new Book(2L, "Book Two", "Author Two", new BigDecimal(600), LocalDate.of(2024, 2, 1));
    }

    @Test
    void testAddBook() {
        when(bookRepository.save(any(Book.class))).thenReturn(book1);
        Book result = bookService.addBook(book1);
        assertNotNull(result);
        assertEquals("Book One", result.getTitle());
    }

    @Test
    void testGetAllBooks() {
        List<Book> books = Arrays.asList(book1, book2);
        when(bookRepository.findAll()).thenReturn(books);
        List<Book> result = bookService.getAllBooks();
        assertEquals(2, result.size());
    }

    @Test
    void testGetBookById() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book1));
        Optional<Book> result = bookService.getBookById(1L);
        assertTrue(result.isPresent());
        assertEquals("Book One", result.get().getTitle());
    }

    @Test
    void testUpdateBook() {
        when(bookRepository.save(any(Book.class))).thenReturn(book1);
        Book result = bookService.updateBook(1L, book1);
        assertNotNull(result);
        assertEquals("Book One", result.getTitle());
    }

    @Test
    void testDeleteBook() {
        doNothing().when(bookRepository).deleteById(1L);
        assertDoesNotThrow(() -> bookService.deleteBook(1L));
        verify(bookRepository, times(1)).deleteById(1L);
    }
}