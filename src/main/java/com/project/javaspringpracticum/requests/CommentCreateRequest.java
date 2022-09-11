package com.project.javaspringpracticum.requests;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CommentCreateRequest {
    Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date commentDate;
    String commentText;
    Long userId;
    Long productId;
}
