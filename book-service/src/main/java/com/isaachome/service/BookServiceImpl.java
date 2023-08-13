package com.isaachome.service;

import com.isaachome.dto.APIResponse;
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
    private  final APIClient apiClient;

    public BookServiceImpl(BookRepos bookRepos, ModelMapper mapper, APIClient apiClient) {
        this.bookRepos = bookRepos;
        this.mapper = mapper;
        this.apiClient = apiClient;
    }

    @Override
    public BookDTO save(BookDTO dto) {
        Book newBook = mapper.map(dto,Book.class);
        var savedBook = bookRepos.save(newBook);
        return mapper.map(savedBook,BookDTO.class);
    }

    @Override
    public List<BookDTO> getBooks() {
        // get
        return bookRepos.findAll().stream().map(it-> mapper.map(it,BookDTO.class)).collect(Collectors.toList());
    }

    @Override
    public APIResponse getBookById(long id) {
        var book = bookRepos.findById(id).orElseThrow(()-> new RuntimeException(""));
        var author = apiClient.getAuthor(book.getAuthorId());

        if (author !=null){
            return new APIResponse(mapper.map(book,BookDTO.class),author);
        }
       return new APIResponse(mapper.map(book,BookDTO.class),null);
    }

}
