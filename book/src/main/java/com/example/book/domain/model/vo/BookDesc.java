package com.example.book.domain.model.vo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class BookDesc {

    private String description;
    private String author;
    private String isbn;
    private LocalDate publicationDate;
    private Source source;

    public static BookDesc createBookDesc(String description, String author, String isbn, LocalDate publicationDate, Source source) {
        return new BookDesc(description, author, isbn, publicationDate, source);
    }

}
