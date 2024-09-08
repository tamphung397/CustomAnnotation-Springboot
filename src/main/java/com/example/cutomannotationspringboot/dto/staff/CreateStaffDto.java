package com.example.cutomannotationspringboot.dto.staff;

import com.example.cutomannotationspringboot.validator.annotation.TamLength;
import com.example.cutomannotationspringboot.validator.annotation.TamNotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStaffDto {
    @TamNotNull
    private String name;

    @TamLength(min = 1, max = 5)
    private String position;

    private int salary;

    @TamNotNull
    private String username;

    @TamNotNull
    private String password;

    @TamNotNull
    private String email;
    public CreateStaffDto(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}
