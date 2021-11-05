package com.ileiwe.data.dto;

import com.ileiwe.data.model.Course;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    private String email;
    private String password;
    private String firstname;
    private String lastname;
}
