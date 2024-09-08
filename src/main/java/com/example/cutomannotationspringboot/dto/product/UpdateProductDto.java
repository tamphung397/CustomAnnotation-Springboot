package com.example.cutomannotationspringboot.dto.product;

import com.example.cutomannotationspringboot.validator.annotation.TamNotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductDto {
    private int id;
    @TamNotNull
    private String name;
    @TamNotNull
    private int price;
    private String description;
}
