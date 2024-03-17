package com.example.book.application.usecase;

import com.example.book.framework.web.dto.BookOutputDTO;

public interface InqueryUseCase {
    public BookOutputDTO getBookInfo(long bookNo);
}
