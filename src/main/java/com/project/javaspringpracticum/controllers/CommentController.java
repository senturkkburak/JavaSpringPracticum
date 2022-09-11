package com.project.javaspringpracticum.controllers;
import com.project.javaspringpracticum.entities.Comment;
import com.project.javaspringpracticum.requests.CommentCreateRequest;
import com.project.javaspringpracticum.services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment>getAllComments(@RequestParam Optional<Long> productId, @RequestParam(required = false)String startDate,@RequestParam(required = false)String endDate){
        Date minDate = startDate ==null ? null:Date.from(LocalDateTime.parse(startDate
        ).atZone(ZoneId.systemDefault()).toInstant());
        Date maxDate = endDate ==null ? null:Date.from(LocalDateTime.parse(endDate
        ).atZone(ZoneId.systemDefault()).toInstant());
        return commentService.getAllComments(productId, Optional.ofNullable(minDate), Optional.ofNullable(maxDate));

    }

    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequest newCommentRequest){
        return commentService.createOneComment(newCommentRequest);
    }
    @GetMapping("/{userId}")
    public List<Comment>getCommentsOfUser(@PathVariable Long userId){
        return commentService.getCommentsOfUser(userId);
    }
    @GetMapping("/{userId}/{startDate}/{endDate}")
    public List<Comment>getCommentsOfUserWithDate(@PathVariable Long userId,@PathVariable String startDate, @PathVariable String endDate){
        Date minDate = startDate ==null ? null:Date.from(LocalDateTime.parse(startDate
        ).atZone(ZoneId.systemDefault()).toInstant());
        Date maxDate = endDate ==null ? null:Date.from(LocalDateTime.parse(endDate
        ).atZone(ZoneId.systemDefault()).toInstant());
        return commentService.getCommentsOfUserWithDate(userId, Optional.ofNullable(minDate), Optional.ofNullable(maxDate));
    }
}
