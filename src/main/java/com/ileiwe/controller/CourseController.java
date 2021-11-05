package com.ileiwe.controller;

import com.ileiwe.data.dto.CourseDto;

import com.ileiwe.data.model.Course;
import com.ileiwe.service.course.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseServiceImpl courseService;

    @PostMapping("/{id}/add")
    public Course createCourse(@RequestBody CourseDto courseDto,@PathVariable("id") Long id){
        return courseService.create(courseDto, id);
    }
    @GetMapping("/{id}")
    public Course viewCourse (@PathVariable("id") Long id){
        return courseService.view(id);
    }
    @GetMapping("/")
    public List<Course> viewCourses(){
        return courseService.view();
    }

    @PatchMapping("/{id}")
    public Course update(@RequestBody CourseDto courseDto, @PathVariable("id") Long id){
        return courseService.update(id, courseDto);
    }
    @DeleteMapping("/{id}")

    public ResponseEntity <?> deleteCourse(@PathVariable  Long id){
        courseService.delete(id);
        return ResponseEntity.noContent().build();

    }


}
