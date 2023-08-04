package com.isaachome.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {

    // get a list of book
    @GetMapping
    public  String getListOfBooks(){
        return "List of Book";
    }
}
