package com.example.book.application.usecase;

import com.example.book.framework.web.dto.BookOutputDTO;

public interface MakeUnAvailableUsecase {

    BookOutputDTO unavailable(Long bookNo);

}
