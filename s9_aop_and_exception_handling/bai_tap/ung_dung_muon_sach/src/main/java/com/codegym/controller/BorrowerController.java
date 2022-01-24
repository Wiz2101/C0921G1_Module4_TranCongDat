package com.codegym.controller;

import com.codegym.dto.BorrowerDto;
import com.codegym.exception.OutOfStock;
import com.codegym.model.Book;
import com.codegym.model.Borrower;
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
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BorrowerController {
    @Autowired
    IBorrowerService borrowerService;

    @GetMapping("/borrower")
    public String showAll(Model model, Pageable pageable) {
        Page<Borrower> borrowers = borrowerService.findAll(pageable);
        model.addAttribute("borrowerList", borrowers);
        return "borrower/view";
    }

//    @GetMapping("borrower/create")
//    public String showCreate(Model model){
//        BorrowerDto borrowerDto = new BorrowerDto();
//        borrowerDto.setBookCode(Math.round(Math.random()*9999 + 1));
//        model.addAttribute("borrowerDto",new BorrowerDto());
//        return "borrower/create";
//    }

    @PostMapping("/borrower/create")
    public String createBorrow(@Validated @ModelAttribute BorrowerDto borrowerDto, BindingResult bindingResult) {
        new BorrowerDto().validate(borrowerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "borrower/create";
        }
        Borrower borrower = new Borrower();

        BeanUtils.copyProperties(borrowerDto, borrower);
        borrower.setBook(new Book(borrowerDto.getBookId()));
        try {
            borrowerService.saveAndUpdate(borrower);
        } catch (OutOfStock e) {
            e.getMessage();
        }
        return "redirect:/book";

    }
}
