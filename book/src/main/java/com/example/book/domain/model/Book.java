package com.example.book.domain.model;

import com.example.book.domain.model.vo.BookDesc;
import com.example.book.domain.model.vo.BookStatus;
import com.example.book.domain.model.vo.Classfication;
import com.example.book.domain.model.vo.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private long no;
    private String title;
    private BookDesc desc;
    private Classfication classfication;
    private BookStatus bookStatus;
    private Location location;

}
