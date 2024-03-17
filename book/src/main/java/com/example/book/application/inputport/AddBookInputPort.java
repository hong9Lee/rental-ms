package com.example.book.application.inputport;

import com.example.book.application.outputport.BookOutPutPort;
import com.example.book.application.usecase.AddBookUsecase;
import com.example.book.domain.model.Book;
import com.example.book.domain.model.vo.Classfication;
import com.example.book.domain.model.vo.Location;
import com.example.book.domain.model.vo.Source;
import com.example.book.framework.web.dto.BookInfoDTO;
import com.example.book.framework.web.dto.BookOutputDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class AddBookInputPort implements AddBookUsecase {

    private final BookOutPutPort bookOutPutPort;

    @Override
    public BookOutputDTO addBook(BookInfoDTO bookInfoDTO) {
        Book book = Book.enterBook(bookInfoDTO.getTitle(), bookInfoDTO.getAuthor(),
                bookInfoDTO.getIsbn(), bookInfoDTO.getDescription(),
                bookInfoDTO.getPublicationDate(),
                Source.valueOf(bookInfoDTO.getSource()),
                Classfication.valueOf(bookInfoDTO.getClassfication()),
                Location.valueOf(bookInfoDTO.getLocation()));
        Book save = bookOutPutPort.save(book);
        return BookOutputDTO.mapToDTO(save);
    }
}
