package com.isaachome.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;
    private String title;
    private String description;
    private int totalPage;
    private  double rating;
    private LocalDate publishedDate;
    private  long authorId;
}
