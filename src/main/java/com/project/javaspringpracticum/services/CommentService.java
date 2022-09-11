package com.project.javaspringpracticum.services;
import com.project.javaspringpracticum.entities.Comment;
import com.project.javaspringpracticum.entities.Product;
import com.project.javaspringpracticum.entities.User;
import com.project.javaspringpracticum.repository.CommentRepository;
import com.project.javaspringpracticum.requests.CommentCreateRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private UserService userService;
    private ProductService productService;
   public CommentService(CommentRepository commentRepository,UserService userService,ProductService productService) {
        this.commentRepository = commentRepository;
        this.userService=userService;
        this.productService=productService;
    }

// *********************Comment Creation************************

    public Comment createOneComment(CommentCreateRequest newCommentRequest) {
       User user = userService.getOneUser(newCommentRequest.getUserId());
        Product product=productService.getOneProduct(newCommentRequest.getProductId());
        if (user==null)
            return null;
        Comment toSave = new Comment();
        toSave.setId(newCommentRequest.getId());
        toSave.setCommentDate(newCommentRequest.getCommentDate());
        toSave.setCommentText(newCommentRequest.getCommentText());
        toSave.setProduct(product);
        toSave.setUser(user);
       return commentRepository.save(toSave);
    }

    //*********************Get All Comments (if only product id is given, returns all comments on that product)
    //if all fields were given, returns all comments on that product between given dates

    public List<Comment> getAllComments(Optional<Long> productId, Optional<Date> minDate, Optional<Date> maxDate) {
       if (productId.isPresent() && minDate.isPresent() && maxDate.isPresent()){
           return commentRepository.findAllByProductIdAndCommentDateBetween(productId.get(), minDate.get(), maxDate.get());
       }else if(productId.isPresent() && !minDate.isPresent() && !maxDate.isPresent()){

           return commentRepository.findByProductId(productId.get());
       }
       return commentRepository.findAll();

    }

    //****************Get all comments of a user******************
    public List<Comment> getCommentsOfUser(Long userId) {
       return commentRepository.findAllByUserId(userId);
    }

    //****************Get all comments of a user between two dates************************
    public List<Comment> getCommentsOfUserWithDate(Long userId, Optional<Date> minDate, Optional<Date> maxDate) {
       return commentRepository.findAllByUserIdAndCommentDateBetween(userId,minDate,maxDate);
    }
}
