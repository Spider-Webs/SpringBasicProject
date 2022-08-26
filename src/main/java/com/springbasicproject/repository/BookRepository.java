package com.springbasicproject.repository;

import com.springbasicproject.domain.Book;

import java.util.List;

public interface BookRepository {

    void save(Book book);

    Book findByIdx(Long idx);

    List<Book> getBookList();

}
