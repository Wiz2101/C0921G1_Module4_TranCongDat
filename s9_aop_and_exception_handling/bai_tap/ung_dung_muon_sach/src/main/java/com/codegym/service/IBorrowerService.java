package com.codegym.service;

import com.codegym.exception.OutOfStock;
import com.codegym.model.Borrower;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBorrowerService {
    Page<Borrower> findAll(Pageable pageable);

    void saveAndUpdate(Borrower borrower) throws OutOfStock;

    Borrower findBorrowerByBookCode(String bookCode);

    void delete(Borrower borrower);
}
