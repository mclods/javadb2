package com.mclods.javadb2.repositories;

import com.mclods.javadb2.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
