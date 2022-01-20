package com.codegym.repository;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface IBlogRepository extends JpaRepository<Blog,Long> {
    public Page<Blog> findAllByAuthorContaining(String keyword,Pageable pageable);
    @Query(value = "SELECT * FROM blog JOIN blog_category ON blog.id = blog_category.blog_id JOIN category ON category.id = blog_category.category_id WHERE category_id = :id and author LIKE :author",countQuery = "SELECT count(*) FROM blog JOIN blog_category ON blog.id = blog_category.blog_id JOIN category ON category.id = blog_category.category_id WHERE category_id = :id and author LIKE :author", nativeQuery = true)
    public Page<Blog> searchByAuthorAndType(@Param("author") String keyword, @Param("id")Long id, Pageable pageable);
}
