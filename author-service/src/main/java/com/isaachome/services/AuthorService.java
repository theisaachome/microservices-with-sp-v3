package com.isaachome.services;

import com.isaachome.dto.AuthorDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    AuthorDTO createAuthor(AuthorDTO dto);
    List<AuthorDTO> getAll();
    AuthorDTO updateAuthor(Long author_id,AuthorDTO dto);
    AuthorDTO getAuthor(Long author_id);
}
