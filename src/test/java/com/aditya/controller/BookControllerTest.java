package com.aditya.controller;

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

import com.aditya.entities.Book;
import com.aditya.service.BookService;

@SpringBootTest
class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        book1 = new Book(1L, "Book One", "Author One", new BigDecimal("500.00"), LocalDate.of(2023, 1, 1));
        book2 = new Book(2L, "Book Two", "Author Two", new BigDecimal("600.00"), LocalDate.of(2024, 2, 1));
    }

    @Test
    void testAddBook() {
        when(bookService.addBook(any(Book.class))).thenReturn(book1);
        Book result = bookController.addBook(book1);
        assertNotNull(result);
        assertEquals("Book One", result.getTitle());
    }

    @Test
    void testGetAllBooks() {
        List<Book> books = Arrays.asList(book1, book2);
        when(bookService.getAllBooks()).thenReturn(books);
        List<Book> result = bookController.getAllBooks();
        assertEquals(2, result.size());
    }

    @Test
    void testGetBookById() {
        when(bookService.getBookById(1L)).thenReturn(Optional.of(book1));
        Optional<Book> result = bookController.getBookById(1L);
        assertTrue(result.isPresent());
        assertEquals("Book One", result.get().getTitle());
    }

    @Test
    void testUpdateBook() {
        when(bookService.updateBook(eq(1L), any(Book.class))).thenReturn(book1);
        Book result = bookController.updateBook(1L, book1);
        assertNotNull(result);
        assertEquals("Book One", result.getTitle());
    }

    @Test
    void testDeleteBook() {
        doNothing().when(bookService).deleteBook(1L);
        assertDoesNotThrow(() -> bookController.deleteBook(1L));
        verify(bookService, times(1)).deleteBook(1L);
    }
}
