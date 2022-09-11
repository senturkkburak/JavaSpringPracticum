package com.project.javaspringpracticum.repository;
import com.project.javaspringpracticum.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long>{

    List<Comment> findByProductId(Long userId);


    List<Comment> findAllByProductIdAndCommentDateBetween(Long productId, Date startDate, Date endDate);

    List<Comment> findAllByUserId(Long userId);

    List<Comment> findAllByUserIdAndCommentDateBetween(Long userId, Optional<Date> minDate, Optional<Date> maxDate);
}
