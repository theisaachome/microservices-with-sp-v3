package com.isaachome.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @Column(name = "author_name",nullable = false,unique = true)
    private  String name;
    @Column(name = "author_email",unique = true)
    private  String email;
    @Column(name = "author_phone")
    private  String phone;
}
