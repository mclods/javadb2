package com.mclods.javadb2.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
    private Integer id;

    private Short age;

    private String name;

    public Author() {

    }

    public Author(Short age, String name) {
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

    public static AuthorBuilder builder() {
        return new AuthorBuilder();
    }

    public static class AuthorBuilder {
        Short age;
        String name;

        public AuthorBuilder age(Short age) {
            this.age = age;
            return this;
        }

        public AuthorBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Author build() {
            return new Author(age, name);
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
