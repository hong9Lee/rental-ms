package com.example.book.application.usecase;

import com.example.book.framework.web.dto.BookInfoDTO;
import com.example.book.framework.web.dto.BookOutputDTO;

public interface AddBookUsecase {

    public BookOutputDTO addBook(BookInfoDTO bookInfoDTO);

}
