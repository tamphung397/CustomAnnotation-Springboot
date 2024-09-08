package com.example.cutomannotationspringboot.dto.product;

import com.example.cutomannotationspringboot.validator.annotation.TamNotNull;
import com.example.cutomannotationspringboot.validator.annotation.TamRange;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDto {
    @TamNotNull
    private String name;
    @TamRange(min = 2000, max = 5000)
    private int price;
    private String description;
}
