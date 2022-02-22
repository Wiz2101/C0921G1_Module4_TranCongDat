package com.codegym.repository;

import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    Page<Employee> findEmployeeByEmployeeNameContaining(String keyword, Pageable pageable);
    Employee findByUsers_User (String username);
    @Query(value="SELECT * FROM employee WHERE employee_name LIKE :name AND position_id LIKE :position AND education_degree_id LIKE :educationDegree AND division_id LIKE :division",nativeQuery = true)
    Page<Employee> searchByNameAndSelect(@Param("name") String keyword, @Param("position") String position, @Param("educationDegree") String educationDegree, @Param("division") String division, Pageable pageable);
}
