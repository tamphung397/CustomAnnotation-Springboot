package com.example.cutomannotationspringboot.service.impl;

import com.example.cutomannotationspringboot.constant.EntityStatus;
import com.example.cutomannotationspringboot.dto.staff.CreateStaffDto;
import com.example.cutomannotationspringboot.dto.staff.StaffDto;
import com.example.cutomannotationspringboot.dto.staff.UpdateStaffDto;
import com.example.cutomannotationspringboot.exception.SpringDemoException;
import com.example.cutomannotationspringboot.service.StaffService;
import com.example.cutomannotationspringboot.springdata.entity.Staff;
import com.example.cutomannotationspringboot.springdata.entity.User;
import com.example.cutomannotationspringboot.springdata.repository.StaffRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<StaffDto> getAllStaff() {
        return staffRepository.findAll()
                .stream()
                .map(staff -> modelMapper.map(staff, StaffDto.class))
                .toList();
    }

    @Override
    public StaffDto getStaffById(int id) throws SpringDemoException {
        Optional<Staff> staffEntityOptional = staffRepository.findById(id);
        Staff staffEntity = staffEntityOptional.orElseThrow(() -> new SpringDemoException("Not found staff"));
        return modelMapper.map(staffEntity, StaffDto.class);
    }

    @Override
    public StaffDto createStaff(CreateStaffDto createStaffDto) {
        Staff staff = modelMapper.map(createStaffDto, Staff.class);
        User user = User.builder().email(createStaffDto.getEmail())
                .username(createStaffDto.getUsername())
                .password(passwordEncoder.encode(createStaffDto.getPassword()))
                .status(EntityStatus.UserStatusEnum.ACTIVE.ordinal())
                .role(EntityStatus.RoleEnum.STAFF.name())
                .build();
        staff.setUser(user);
        staff.setStatus(EntityStatus.UserStatusEnum.ACTIVE.ordinal());
        Staff savedStaff = staffRepository.save(staff);

        //Return saved data
        return modelMapper.map(savedStaff, StaffDto.class);
    }

    @Override
    public StaffDto updateStaff(UpdateStaffDto updateStaffDto) throws SpringDemoException {
        Optional<Staff> staffEntityOptional = staffRepository.findById(updateStaffDto.getId());
        Staff staffEntity = staffEntityOptional.orElseThrow(() -> new SpringDemoException("Not found staff"));

        //update data
        staffEntity.setName(updateStaffDto.getName());
        staffEntity.setPosition(updateStaffDto.getPosition());
        staffEntity.setSalary(updateStaffDto.getSalary());
        staffEntity.getUser().setEmail(updateStaffDto.getEmail());
        Staff savedStaff = staffRepository.save(staffEntity);

        //return saved data
        return modelMapper.map(savedStaff, StaffDto.class);
    }

    @Override
    public void deleteStaff(int id) throws SpringDemoException {
        Optional<Staff> staffEntityOptional = staffRepository.findById(id);
        Staff staffEntity = staffEntityOptional.orElseThrow(() -> new SpringDemoException("Not found staff"));
        staffEntity.setStatus(EntityStatus.StaffStatusEnum.DISABLE.ordinal());
        staffEntity.getUser().setStatus(EntityStatus.UserStatusEnum.DISABLE.ordinal());
        staffRepository.save(staffEntity);
    }
}
