package com.isaachome.controller;

import com.isaachome.dto.AuthorDTO;
import com.isaachome.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private  final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public List<AuthorDTO> getAllAuthors(){
        return  authorService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthor(@PathVariable("id")long authorId){
        return  new ResponseEntity<>(authorService.getAuthor(authorId),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<AuthorDTO> addAuthor(@RequestBody AuthorDTO authorDTO){
        return new ResponseEntity<>(authorService.createAuthor(authorDTO), HttpStatus.CREATED);
    }
}
