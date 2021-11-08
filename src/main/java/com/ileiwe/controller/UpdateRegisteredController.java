package com.ileiwe.controller;

import com.ileiwe.data.model.Course;
import com.ileiwe.data.model.Instructor;
import com.ileiwe.data.model.Student;
import com.ileiwe.service.instructor.InstructorServiceImpl;
import com.ileiwe.service.student.StudentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@Slf4j



public class UpdateRegisteredController {
    @Autowired
    InstructorServiceImpl instructorService;

    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("instructor/{id}")
    public Instructor viewInstructorById(@PathVariable("id")Long id){
        return instructorService.search(id);
    }
    @GetMapping("/instructor")
    public List<Instructor> viewAllInstructors(){
        return instructorService.search();
    }

    @PutMapping("enroll_course/{id}/{course_id}")
    public Student studentEnrollCourse(@PathVariable("id") Long id, @PathVariable Long course_id ){
        return studentService.enrollForCourse(id, course_id);
    }
    @GetMapping("enable_student/{id}")
    public Student enableStudent(@PathVariable("id")Long id){
        return studentService.enableStudent(id);
    }
    @GetMapping("student_courses/{id}")
    public List<Course> getAllCourses(@PathVariable("id")Long id){
        return studentService.getMyCourse(id);
    }
    @PutMapping("unenroll_course/{id}/{course_id}")
    public Student unEnrollCourse(@PathVariable("id") Long id, @PathVariable Long course_id){
        return studentService.unEnrollForCourse(id, course_id);
    }




}
