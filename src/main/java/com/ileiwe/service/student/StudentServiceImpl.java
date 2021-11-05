package com.ileiwe.service.student;

import com.ileiwe.data.dto.StudentDto;
import com.ileiwe.data.model.*;
import com.ileiwe.data.repository.CourseRepository;
import com.ileiwe.data.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;


    @Override
    public Student createStudent(StudentDto studentDto) {
        if (studentDto == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        LearningParty learningParty = new LearningParty(studentDto.getEmail(), studentDto.getPassword(), new Authority(Role.ROLE_STUDENT));
        Student student = Student.builder().lastname(studentDto.getLastname()).firstname(studentDto.getFirstname()).learningParty(learningParty).build();


        return studentRepository.save(student);
    }

    @Override
    public Student enrollForCourse(Long id) {
        return null;
    }

    @Override
    public Student unEnrollForCourse(Long id) {
        return null;
    }

    @Override
    public Student searchForStudent(String name) {
        return null;
    }

    @Override
    public List<Course> getMyCourse(Long id) {
        Student student = studentRepository.findById(id).get();

        if (id.equals(student.getId())) {

            return courseRepository.findAll();


        }else return null;
    }
}