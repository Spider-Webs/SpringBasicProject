package com.springbasicproject.service;

import com.springbasicproject.domain.Book;
import com.springbasicproject.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }


    @Override
    public void save(Book book) {
        bookDao.save(book);
    }

    @Override
    public Book findBook(Long idx) {
        return bookDao.findByIdx(idx);
    }

    @Override
    public List<Book> getBookList() {
        List<Book> bookList = bookDao.getBookList();

        return bookList;
    }
}
