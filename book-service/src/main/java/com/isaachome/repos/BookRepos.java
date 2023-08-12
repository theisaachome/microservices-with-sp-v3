package com.isaachome.repos;

import com.isaachome.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepos extends JpaRepository<Book,Long> {
}
