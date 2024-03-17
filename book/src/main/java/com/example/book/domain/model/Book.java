package com.example.book.domain.model;

import com.example.book.domain.model.vo.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private long no;
    private String title;
    private BookDesc desc;
    private Classfication classfication;
    private BookStatus bookStatus;
    private Location location;

    public static Book enterBook(String title, String author,
                                 String isbn,
                                 String description,
                                 LocalDate publicationDate,
                                 Source source,
                                 Classfication classfication,
                                 Location location) {
        BookDesc bookDesc = BookDesc.createBookDesc(author, isbn, description, publicationDate, source);
        Book book = new Book();
        book.setTitle(title);
        book.setDesc(bookDesc);
        book.setClassfication(classfication);
        book.setBookStatus(BookStatus.ENTERED);
        return book;
    }

    public Book makeAvailable() {
        this.setBookStatus(BookStatus.AVAILABLE);
        return this;
    }

    public Book makeUnAvailable() {
        this.setBookStatus(BookStatus.UNAVAILABLE);
        return this;
    }

}
