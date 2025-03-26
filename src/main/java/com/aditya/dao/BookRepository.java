package com.aditya.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aditya.entities.Book;

//Repository interface for Book entity
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	// JpaRepository provides built-in CRUD operations, no need to write implementation
}
