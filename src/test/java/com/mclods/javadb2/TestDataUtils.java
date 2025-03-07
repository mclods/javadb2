package com.mclods.javadb2;

import com.mclods.javadb2.domain.Author;
import com.mclods.javadb2.domain.Book;

public class TestDataUtils {
    public static Author testAuthorA() {
        return Author.builder()
                .age((short)44)
                .name("Dennis Levi")
                .build();
    }

    public static Book testBookA(Author author) {
        return Book.builder()
                .isbn("978-1-2345-6789-0")
                .title("Dark Soul")
                .author(author)
                .build();
    }
}
