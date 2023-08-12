package com.isaachome.service;

import com.isaachome.dto.BookDTO;
import com.isaachome.entity.Book;

import java.util.List;

public interface BookService {
    BookDTO save(BookDTO book);
    List<BookDTO> getBooks();

}
