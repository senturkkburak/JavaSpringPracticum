package com.project.javaspringpracticum.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="comment")
@Data
public class Comment {
    @Id
    Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date commentDate;
    @ManyToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "userId")
            @OnDelete(action = OnDeleteAction.CASCADE)
            @JsonIgnore
    User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    Product product;

    @Lob
    @Column(columnDefinition = "text")
    String commentText;

}
