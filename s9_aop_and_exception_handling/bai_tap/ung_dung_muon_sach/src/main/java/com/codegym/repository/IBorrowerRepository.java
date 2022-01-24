package com.codegym.repository;

import com.codegym.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowerRepository extends JpaRepository<Borrower,Long> {
    Borrower findBorrowerByBookCode(String bookCode);
}
