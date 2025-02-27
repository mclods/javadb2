package com.mclods.javadb2.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    String isbn;

    String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    Author author;

    public Book(String isbn, String title, Author author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public BookBuilder builder() {
        return new BookBuilder();
    }

    public static class BookBuilder {
        String isbn, title;
        Author author;

        public BookBuilder isbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public BookBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder author(Author author) {
            this.author = author;
            return this;
        }

        public Book build() {
            return new Book(isbn, title, author);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(!(obj instanceof Book bookObj)) {
            return false;
        }

        return isbn.equals(bookObj.isbn) &&
                title.equals(bookObj.title) &&
                author.equals(bookObj.author);
    }

    @Override
    public String toString() {
        return String.format("Book(isbn = %s, title = %s, author = %s)", isbn, title, author);
    }
}
