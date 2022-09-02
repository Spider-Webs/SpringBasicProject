package com.springbasicproject.controller;

import com.springbasicproject.domain.Book;
import com.springbasicproject.repository.BookRepositoryImpl;
import com.springbasicproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String bookCreate(){
        return "book/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPost(@ModelAttribute Book book){


        bookService.save(book);

        return "book/createSuccess";
    }

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(@RequestParam Long idx, Model model){

        Book book = bookService.findBook(idx);
        model.addAttribute("book", book);
        return "book/detailBook";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        List<Book> bookList = bookService.getBookList();
        model.addAttribute("bookList", bookList);
        return "book/list";
    }
}
