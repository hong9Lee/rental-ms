package com.example.book.framework.web.dto;

import com.example.book.domain.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookOutputDTO {

    private long bookNo;
    private String bookTitle;
    private String bookStatus;

    public static BookOutputDTO mapToDTO(Book book) {
        BookOutputDTO bookOutputDTO = new BookOutputDTO();
        bookOutputDTO.setBookNo(bookOutputDTO.getBookNo());
        bookOutputDTO.setBookTitle(bookOutputDTO.getBookTitle());
        bookOutputDTO.setBookStatus(bookOutputDTO.getBookStatus());
        return bookOutputDTO;
    }

}
