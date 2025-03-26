package com.aditya.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

//Entity class representing a Book in the database
@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    
    // Primary key
    private Long id;
    
    //Attribute for title of the book
    private String title;
    
    //Attribute for author of the book
    private String author;
    
    //Attribute for price of the book
    private BigDecimal price;
    
    //Attribute for published date 
    private LocalDate publishedDate;
    
    public Book(Long id, String title, String author, BigDecimal price, LocalDate publishedDate) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.publishedDate = publishedDate;
	}

	//getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
}
