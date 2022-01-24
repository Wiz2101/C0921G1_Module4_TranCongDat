package com.codegym.service;

import com.codegym.exception.OutOfStock;
import com.codegym.model.Book;
import com.codegym.model.Borrower;
import com.codegym.repository.IBorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BorrowerService implements IBorrowerService {
    @Autowired
    IBorrowerRepository borrowerRepository;

    @Autowired
    IBookService bookService;

    @Override
    public Page<Borrower> findAll(Pageable pageable) {
        return borrowerRepository.findAll(pageable);
    }

    @Override
    public void saveAndUpdate(Borrower borrower) throws OutOfStock{
        Book book = bookService.findById(borrower.getBook().getId());
        if (book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            bookService.saveAndUpdate(book);
            borrowerRepository.save(borrower);
        } else {
            throw new OutOfStock();
        }
    }

    @Override
    public Borrower findBorrowerByBookCode(String bookCode) {
        return borrowerRepository.findBorrowerByBookCode(bookCode);
    }

    @Override
    public void delete(Borrower borrower) {
        borrowerRepository.delete(borrower);
    }
}
