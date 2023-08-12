package com.isaachome.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "book_title",nullable = false,unique = true)
    private String title;
    @Column(name = "book_description")
    private String description;
    @Column(name = "total_page",nullable = false)
    private int totalPage;
    private  double rating;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "published_date")
    private LocalDate publishedDate;

}
