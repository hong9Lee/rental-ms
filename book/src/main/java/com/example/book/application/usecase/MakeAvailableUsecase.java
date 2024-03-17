package com.example.book.application.usecase;

import com.example.book.framework.web.dto.BookOutputDTO;

public interface MakeAvailableUsecase {
    public BookOutputDTO available(Long bookNo);
}
