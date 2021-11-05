package com.ileiwe.service.student;

import com.ileiwe.data.dto.StudentDto;
import com.ileiwe.data.model.Course;
import com.ileiwe.data.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentDto studentDto);
    Student enrollForCourse(Long id);
    Student unEnrollForCourse(Long id);
    Student searchForStudent(String name);
    List<Course> getMyCourse(Long id);
}
