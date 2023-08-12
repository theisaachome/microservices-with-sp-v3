package com.isaachome.controller;

import com.isaachome.dto.BookDTO;
import com.isaachome.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private  final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // get a list of book
    @GetMapping
    public List<BookDTO> getListOfBooks(){
        return bookService.getBooks();
    }

    // create new Book record
    @PostMapping()
    public ResponseEntity<BookDTO> addNewBook(@RequestBody BookDTO bookDTO){
        return  new ResponseEntity<>(bookService.save(bookDTO), HttpStatus.CREATED);
    }
}
