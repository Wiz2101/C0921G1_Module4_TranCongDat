package com.codegym.service;

import com.codegym.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);

    void saveAndUpdate(Book book);

    void delete(Long id);

    Book findById(Long id);

    Book findBookByCode(String bookCode);
}
