package com.springbasicproject.repository;

import com.springbasicproject.domain.Book;
import com.springbasicproject.mapper.BookMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao {

    private final BookMapper bookMapper;

    public BookDao(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public void save(Book book){
        bookMapper.save(book);
    }

    public Book findByIdx(Long idx){
        return bookMapper.findByIdx(idx);
    }

    public List<Book> getBookList() {
        return bookMapper.getBookList();
    }
}
