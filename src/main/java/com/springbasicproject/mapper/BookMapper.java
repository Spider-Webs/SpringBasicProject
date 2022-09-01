package com.springbasicproject.mapper;

import com.springbasicproject.domain.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper {

    @Insert("insert into Book(idx, subject, category, price) \n" +
            "values (#{idx}, #{subject}, #{category}, #{price})")
    void save(Book book);

    @Select("select idx, subject, category, price from Book where idx=#{idx}")
    Book findByIdx(Long idx);

    @Select("select idx, subject, category, price from Book")
    List<Book> getBookList();

}
