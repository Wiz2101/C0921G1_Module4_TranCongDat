package com.codegym.controller;

import com.codegym.dto.BookDto;
import com.codegym.dto.BorrowerDto;
import com.codegym.model.Book;
import com.codegym.model.Borrower;
import com.codegym.service.IBookService;
import com.codegym.service.IBorrowerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    @Autowired
    IBookService bookService;

    @Autowired
    IBorrowerService borrowerService;

    @GetMapping("/book")
    public String showAll (Pageable pageable, Model model){
        Page<Book> books = bookService.findAll(pageable);
        model.addAttribute("bookList",books);
        return "book/view";
    }

    @GetMapping("/book/detail/{id}")
    public String showDetail(@PathVariable Long id, Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book",book);
        return "book/detail";
    }

    @GetMapping("/book/create")
    public String showCreate (Model model){
        model.addAttribute("bookDto",new BookDto());
        return "book/create";
    }

    @PostMapping("/book/create")
    public String create(@Validated @ModelAttribute BookDto bookDto, BindingResult bindingResult){
        new BookDto().validate(bookDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "book/create";
        }
        Book book = new Book();
        BeanUtils.copyProperties(bookDto,book);
        bookService.saveAndUpdate(book);
        return "redirect:/book";
    }

    @GetMapping("/book/borrow/{id}")
    public String showCreateBorrow(@PathVariable Long id, Model model){
        Book book = bookService.findById(id);
        BorrowerDto borrowerDto = new BorrowerDto();
        borrowerDto.setBookId(book.getId());
        borrowerDto.setBookCode(book.getCode());
        model.addAttribute("borrowerDto",borrowerDto);
        model.addAttribute("book",book);
        return "borrower/create";
    }

    @GetMapping("/book/return")
    public String showReturnForm(Model model){
        model.addAttribute("bookDto",new BookDto());
        return "book/return";
    }

    @PostMapping("/book/return")
    public String returnBook (@ModelAttribute BookDto bookDto, Model model){
        Book book = bookService.findBookByCode(bookDto.getCode());
        book.setQuantity(book.getQuantity() + 1);
        bookService.saveAndUpdate(book);
        Borrower borrower = borrowerService.findBorrowerByBookCode(bookDto.getCode());
        borrowerService.delete(borrower);
        return "redirect:/book";
    }
}
