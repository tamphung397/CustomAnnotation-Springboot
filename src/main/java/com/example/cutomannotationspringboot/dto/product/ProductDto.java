package com.example.cutomannotationspringboot.dto.product;

import com.example.cutomannotationspringboot.validator.annotation.TamLength;
import com.example.cutomannotationspringboot.validator.annotation.TamNotNull;
import com.example.cutomannotationspringboot.validator.annotation.TamRange;
import lombok.Data;

@Data
public class ProductDto {
    private int id;
    private String name;
    private int price;
    private String description;
}
