package com.example.cutomannotationspringboot.service;

import com.example.cutomannotationspringboot.dto.staff.CreateStaffDto;
import com.example.cutomannotationspringboot.dto.staff.StaffDto;
import com.example.cutomannotationspringboot.dto.staff.UpdateStaffDto;
import com.example.cutomannotationspringboot.exception.SpringDemoException;

import java.util.List;

public interface StaffService {
    List<StaffDto> getAllStaff();
    StaffDto getStaffById(int id) throws SpringDemoException;
    StaffDto createStaff(CreateStaffDto createStaffDto);
    StaffDto updateStaff(UpdateStaffDto updateStaffDto) throws SpringDemoException;
    void deleteStaff(int id) throws SpringDemoException;
}
