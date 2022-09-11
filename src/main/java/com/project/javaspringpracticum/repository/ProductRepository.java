package com.project.javaspringpracticum.repository;
import com.project.javaspringpracticum.entities.Comment;
import com.project.javaspringpracticum.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long>{

    List<Product> findAllByExpireDateBefore(Date now);

    List<Product> findAllByExpireDateAfterOrExpireDateIsNull(Date date);
}
