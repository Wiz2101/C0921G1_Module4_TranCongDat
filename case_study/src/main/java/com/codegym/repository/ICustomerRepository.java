package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    Page<Customer> findCustomerByCustomerNameContaining(String keyword, Pageable pageable);
    @Query(value = "SELECT * FROM customer\n" +
            "JOIN contract ON contract.customer_id = customer.customer_id\n" +
            "JOIN service ON service.service_id = contract.service_id\n" +
            "LEFT JOIN contract_detail ON contract_detail.contract_id = contract.contract_id\n" +
            "LEFT JOIN attach_service ON attach_service.attach_service_id = contract_detail.attach_service_id\n" +
            "WHERE contract_start_date REGEXP :date\n",nativeQuery = true)
    Page<Customer> findAllByDate(@Param("date") String date, Pageable pageable);
}
