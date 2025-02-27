package com.mclods.javadb2.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
    private final Integer id;
    private final Short age;
    private final String name;

    public Author(Integer id, Short age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Short getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public AuthorBuilder builder() {
        return new AuthorBuilder();
    }

    public static class AuthorBuilder {
        Integer id;
        Short age;
        String name;

        public AuthorBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public AuthorBuilder age(Short age) {
            this.age = age;
            return this;
        }

        public AuthorBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Author build() {
            return new Author(id, age, name);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(!(obj instanceof Author authorObj)) {
            return false;
        }

        return id.equals(authorObj.id) &&
                age.equals(authorObj.age) &&
                name.equals(authorObj.name);
    }

    @Override
    public String toString() {
        return String.format("Author(id = %d, age = %d, name = %s)", id, age, name);
    }
}
