package com.codegym.repository;

import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
    @Query(value = "SELECT * FROM blog_category JOIN blog ON blog.id = blog_category.blog_id JOIN category ON category.id = blog_category.category_id WHERE category_id = :id", nativeQuery = true)
    public Page<Category> searchById(@Param("id") Long id, Pageable pageable);
}
