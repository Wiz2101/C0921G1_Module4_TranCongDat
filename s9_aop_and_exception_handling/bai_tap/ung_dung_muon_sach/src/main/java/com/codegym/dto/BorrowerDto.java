package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BorrowerDto implements Validator {
    private String name;
    private String bookCode;
    private String borrowedDate;
    private String returnDate;
    private Long bookId;
    public BorrowerDto() {
    }

    public BorrowerDto(String name, String bookCode, String borrowedDate, String returnDate) {
        this.name = name;
        this.bookCode = bookCode;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BorrowerDto borrowerDto = (BorrowerDto) target;
    }
}
