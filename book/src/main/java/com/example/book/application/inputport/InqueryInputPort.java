package com.example.book.application.inputport;

import com.example.book.application.outputport.BookOutPutPort;
import com.example.book.application.usecase.InqueryUseCase;
import com.example.book.domain.model.Book;
import com.example.book.framework.web.dto.BookOutputDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
public class InqueryInputPort implements InqueryUseCase {

    private final BookOutPutPort bookOutPutPort;
    @Override
    public BookOutputDTO getBookInfo(long bookNo) {
        Book book = bookOutPutPort.loadBook(bookNo);
        return BookOutputDTO.mapToDTO(book);
    }
}
