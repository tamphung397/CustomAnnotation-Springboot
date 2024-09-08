package com.example.cutomannotationspringboot.dto.staff;

import com.example.cutomannotationspringboot.validator.annotation.TamLength;
import com.example.cutomannotationspringboot.validator.annotation.TamNotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStaffDto {
    private int id;

    @TamNotNull
    private String name;

    @TamLength(min = 1, max = 5)
    private String position;

    private int salary;

    @TamNotNull
    private String email;
}
