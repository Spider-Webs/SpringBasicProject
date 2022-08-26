package com.springbasicproject.service;

import com.springbasicproject.domain.Book;

import java.util.List;

public interface BookService {

    void save(Book book);

    Book findBook(Long idx);

    List<Book> getBookList();

}
