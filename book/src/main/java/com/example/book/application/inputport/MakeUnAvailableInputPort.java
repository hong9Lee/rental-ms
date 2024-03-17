package com.example.book.application.inputport;

import com.example.book.application.outputport.BookOutPutPort;
import com.example.book.application.usecase.MakeUnAvailableUsecase;
import com.example.book.domain.model.Book;
import com.example.book.framework.web.dto.BookOutputDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class MakeUnAvailableInputPort implements MakeUnAvailableUsecase {

    private final BookOutPutPort bookOutPutPort;

    @Override
    public BookOutputDTO unavailable(long bookNo) {
        Book loadBook = bookOutPutPort.loadBook(bookNo);
        loadBook.makeUnAvailable();
        return BookOutputDTO.mapToDTO(loadBook);
    }
}
