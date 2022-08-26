package com.springbasicproject.service;

import com.springbasicproject.domain.Book;
import com.springbasicproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void save(Book book) {
        System.out.println("서비스"+book.getSubject());
        bookRepository.save(book);
    }

    @Override
    public Book findBook(Long idx) {
        return bookRepository.findByIdx(idx);
    }

    @Override
    public List<Book> getBookList() {
        List<Book> bookList = bookRepository.getBookList();

        return bookList;
    }
}
