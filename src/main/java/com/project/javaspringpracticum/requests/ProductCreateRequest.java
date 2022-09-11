package com.project.javaspringpracticum.requests;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.Optional;

@Data
public class ProductCreateRequest {
    Long id;
    String name;
    String price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Nullable
    Date expireDate;
}
