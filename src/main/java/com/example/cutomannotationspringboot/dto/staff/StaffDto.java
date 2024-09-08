package com.example.cutomannotationspringboot.dto.staff;


import com.example.cutomannotationspringboot.validator.annotation.TamLength;
import com.example.cutomannotationspringboot.validator.annotation.TamNotNull;
import com.example.cutomannotationspringboot.validator.annotation.TamRange;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDto {
    private int id;
    private String name;
    private String position;
    private int salary;
}
