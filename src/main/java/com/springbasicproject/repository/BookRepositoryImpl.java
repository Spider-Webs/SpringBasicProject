package com.springbasicproject.repository;

import com.springbasicproject.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepositoryImpl implements BookRepository {

    Map<Long, Book> store = new HashMap<>();
    static long count;

    @Override
    public void save(Book book) {

        book.setIdx(++count);
        store.put(book.getIdx(), book);
    }

    @Override
    public Book findByIdx(Long idx) {
        return store.get(idx);
    }

    @Override
    public List<Book> getBookList() {
        List<Book> list = new ArrayList<>();
        for(Long id: store.keySet()){
            Book book = store.get(id);
            list.add(book);
        }


        return list;
    }
}
