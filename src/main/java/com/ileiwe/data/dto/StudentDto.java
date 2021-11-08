package com.ileiwe.data.dto;

import com.ileiwe.data.model.Course;
import lombok.Data;

import javax.validation.constraints.Email;
import java.util.List;

@Data
public class StudentDto {
    @Email
    private String email;
    private String password;
    private String firstname;
    private String lastname;
}
