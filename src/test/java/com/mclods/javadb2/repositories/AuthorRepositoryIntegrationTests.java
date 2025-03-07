package com.mclods.javadb2.repositories;

import com.mclods.javadb2.TestDataUtils;
import com.mclods.javadb2.domain.Author;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class AuthorRepositoryIntegrationTests {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorRepositoryIntegrationTests(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Test
    @DisplayName("Test author can be created and recalled")
    void testAuthorCanBeCreatedAndRecalled() {
        Author author = TestDataUtils.testAuthorA();

        authorRepository.save(author);
        Optional<Author> result = authorRepository.findById(author.getId());
        assertThat(result).isPresent();
        assertThat(result.get())
                .extracting(Author::getName, Author::getAge)
                .containsExactly("Dennis Levi", (short)44);
    }
}
