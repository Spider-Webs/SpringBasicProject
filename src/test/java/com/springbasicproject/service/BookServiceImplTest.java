package com.springbasicproject.service;

import com.springbasicproject.domain.Book;
import com.springbasicproject.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void save() {
        Book book = new Book();
        book.setIdx(1l);
        book.setSubject("스프링");
        book.setCategory("id");
        book.setPrice(1000);

        bookRepository.save(book);
        Book byIdx = bookRepository.findByIdx(1l);
        assertThat("스프링").isEqualTo(byIdx.getSubject());
    }

    @Test
    void findBook() {
        System.out.println();
        Book byIdx = bookRepository.findByIdx(1L);
        assertThat("스프링").isEqualTo(byIdx.getSubject());

    }
}