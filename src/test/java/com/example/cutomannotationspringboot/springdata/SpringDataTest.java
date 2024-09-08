package com.example.cutomannotationspringboot.springdata;

import com.example.cutomannotationspringboot.dto.staff.CreateStaffDto;
import com.example.cutomannotationspringboot.service.StaffService;
import com.example.cutomannotationspringboot.springdata.entity.Staff;
import com.example.cutomannotationspringboot.springdata.entity.User;
import com.example.cutomannotationspringboot.springdata.repository.StaffRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringDataTest {
    @Autowired
    private StaffService staffService;

    @Test
    public void createStaff(){
        CreateStaffDto createStaffDto = new CreateStaffDto("staff1","Dev",4000,"test2","1234","test@gmail.com");
        staffService.createStaff(createStaffDto);
    }
}
