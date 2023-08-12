package com.isaachome.service;

import com.isaachome.dto.BookDTO;
import com.isaachome.entity.Book;
import com.isaachome.repos.BookRepos;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements  BookService{

    private  final BookRepos bookRepos ;
    private  final ModelMapper mapper;

    public BookServiceImpl(BookRepos bookRepos, ModelMapper mapper) {
        this.bookRepos = bookRepos;
        this.mapper = mapper;
    }

    @Override
    public BookDTO save(BookDTO dto) {
        Book newBook = mapper.map(dto,Book.class);
        var savedBook = bookRepos.save(newBook);
        return mapper.map(savedBook,BookDTO.class);
    }

    @Override
    public List<BookDTO> getBooks() {
        return bookRepos.findAll().stream().map(it-> mapper.map(it,BookDTO.class)).collect(Collectors.toList());
    }
}
