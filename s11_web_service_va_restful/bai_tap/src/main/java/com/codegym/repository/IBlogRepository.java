package com.codegym.repository;

import ch.qos.logback.core.boolex.EvaluationException;
import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface IBlogRepository extends JpaRepository<Blog,Long> {
    public Page<Blog> findAllByAuthorContaining(String keyword, Pageable pageable);
    @Query(value = "SELECT * FROM blog JOIN blog_category ON blog.id = blog_category.blog_id JOIN category ON category.id = blog_category.category_id WHERE category_id = :id and author LIKE :author ORDER BY create_date ASC", nativeQuery = true)
    public Page<Blog> searchByAuthorAndType(@Param("author") String keyword, @Param("id")Long id, Pageable pageable);
    @Query(value = "SELECT * FROM blog JOIN blog_category ON blog.id = blog_category.blog_id JOIN category ON category.id = blog_category.category_id WHERE category_id = :id ORDER BY create_date ASC", nativeQuery = true)
    public Iterable<Blog> findAllByCategory(@Param("id") Long id);
}
