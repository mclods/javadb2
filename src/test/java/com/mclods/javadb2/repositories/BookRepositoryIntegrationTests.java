package com.mclods.javadb2.repositories;

import com.mclods.javadb2.TestDataUtils;
import com.mclods.javadb2.domain.Author;
import com.mclods.javadb2.domain.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class BookRepositoryIntegrationTests {
    private final BookRepository bookRepository;

    @Autowired
    public BookRepositoryIntegrationTests(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Test
    @DisplayName("Test book can be created and recalled")
    void testBookCanBeCreatedAndRecalled() {
        Author author = TestDataUtils.testAuthorA();
        Book book = TestDataUtils.testBookA(author);

        bookRepository.save(book);
        Optional<Book> result = bookRepository.findById(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get())
                .extracting(Book::getIsbn, Book::getTitle)
                .containsExactly("978-1-2345-6789-0", "Dark Soul");
    }
}
