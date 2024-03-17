package com.example.book.framework.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInfoDTO {

    private String title;
    private String description;
    private String author;
    private String isbn;
    private LocalDate publicationDate;
    private String source;
    private String classfication;
    private String location;


}
