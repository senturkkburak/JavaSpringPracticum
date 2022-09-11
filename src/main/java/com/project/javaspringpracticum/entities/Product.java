package com.project.javaspringpracticum.entities;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="product")
@Data
public class Product {
    @Id
    Long id;
    String name;
    String price;
    @Nullable
    Date expireDate;
}
