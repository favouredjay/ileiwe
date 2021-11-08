package com.ileiwe.service.student;

import com.ileiwe.data.dto.StudentDto;
import com.ileiwe.data.model.Course;
import com.ileiwe.data.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentDto studentDto);
    Student enrollForCourse(Long id, Long courseId);
    Student unEnrollForCourse(Long id, Long courseId);
    Student searchForStudent(Long id);
    List<Course> getMyCourse(Long id);
    Student enableStudent (Long id);
}
