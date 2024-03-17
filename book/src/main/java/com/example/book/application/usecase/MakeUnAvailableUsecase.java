package com.example.book.application.usecase;

import com.example.book.framework.web.dto.BookOutputDTO;

public interface MakeUnAvailableUsecase {

    public BookOutputDTO unavailable(long bookNo);

}
