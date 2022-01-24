package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BookDto implements Validator {
    private String code;
    private String tittle;
    private String mainContent;
    private String author;
    private String type;
    Long quantity;

    public BookDto() {
    }

    public BookDto(String code, String tittle, String mainContent, String author, String type, Long quantity) {
        this.code = code;
        this.tittle = tittle;
        this.mainContent = mainContent;
        this.author = author;
        this.type = type;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getMainContent() {
        return mainContent;
    }

    public void setMainContent(String mainContent) {
        this.mainContent = mainContent;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookDto bookDto = (BookDto) target;
    }
}
