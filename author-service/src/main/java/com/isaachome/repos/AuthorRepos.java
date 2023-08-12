package com.isaachome.repos;

import com.isaachome.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepos extends JpaRepository<Author,Long> {
}
