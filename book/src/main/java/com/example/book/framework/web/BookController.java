package com.example.book.framework.web;

import com.example.book.application.usecase.AddBookUsecase;
import com.example.book.application.usecase.InqueryUseCase;
import com.example.book.framework.web.dto.BookInfoDTO;
import com.example.book.framework.web.dto.BookOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookController {

    private final AddBookUsecase addBookUsecase;
    private final InqueryUseCase inqueryUseCase;

    @PostMapping("/book")
    public ResponseEntity<BookOutputDTO> createBook(@RequestBody BookInfoDTO bookInfoDTO) {
        BookOutputDTO bookOutputDTO = addBookUsecase.addBook(bookInfoDTO);
        return new ResponseEntity<>(bookOutputDTO, HttpStatus.CREATED);
    }

    @GetMapping("/book/{no}")
    public ResponseEntity<BookOutputDTO> getBookNo(@PathVariable("no") String no) {
        BookOutputDTO bookInfo = inqueryUseCase.getBookInfo(Long.parseLong(no));
        return bookInfo != null
                ? new ResponseEntity<>(bookInfo, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
