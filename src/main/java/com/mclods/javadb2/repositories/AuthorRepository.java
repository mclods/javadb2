package com.mclods.javadb2.repositories;

import com.mclods.javadb2.domain.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
    Iterable<Author> findByAgeLessThan(short age);

    @Query("SELECT a from Author a WHERE a.age > ?1")
    Iterable<Author> findAuthorAgeGreaterThan(short age);
}
