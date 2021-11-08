package com.ileiwe.service.student;

import com.ileiwe.data.dto.CourseDto;
import com.ileiwe.data.dto.StudentDto;
import com.ileiwe.data.model.*;
import com.ileiwe.data.repository.CourseRepository;
import com.ileiwe.data.repository.StudentRepository;
import com.ileiwe.service.course.CourseServiceImpl;
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

    @Autowired
    CourseServiceImpl courseService;


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
    public Student enrollForCourse(Long id, Long courseId) {
        Student student = studentRepository.findById(id).orElse(null);
        Course course = courseService.view(courseId);
        if(student == null){
            throw  new NullPointerException("Student cannot be null");
        }
        if(!student.getLearningParty().isEnabled()){
            throw new IllegalArgumentException("Student need to be activated");
        }
        course.getStudents().add(student);
       student.getEnrolledCourses().add(course);
        return studentRepository.save(student);
    }


    @Override
    public Student unEnrollForCourse(Long id, Long courseId) {
        Student student = studentRepository.findById(id).orElse(null);
        if(student == null){
            throw new NullPointerException("student cannot be null");
        }
        Course course = courseService.view(courseId);
        if(!student.getLearningParty().isEnabled()){
            throw new IllegalArgumentException("Student need to be activated");
        }
        course.getStudents().removeIf(student1 -> student1.getId().equals(id));
        student.getEnrolledCourses().removeIf(course1 -> course1.getId().equals(courseId));

        return null;
    }

    @Override
    public Student searchForStudent(Long id) {

        return studentRepository.findById(id).orElse(null) ;
    }

    @Override
    public List<Course> getMyCourse(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if(student == null){
            throw new NullPointerException("Null");
        }
        if (!student.getLearningParty().isEnabled()){
            throw new RuntimeException("student not activated");
        }

       return student.getEnrolledCourses();
    }

    @Override
    public Student enableStudent(Long id) {
        Student student = studentRepository.findById(id).get();

       student.getLearningParty().setEnabled(true);

        return studentRepository.save(student);
    }
}