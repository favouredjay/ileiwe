package com.ileiwe.service.course;

import com.ileiwe.data.dto.CourseDto;
import com.ileiwe.data.model.Course;

import java.util.List;

public interface CourseService {
    Course create(CourseDto courseDto, Long id);
    Course update(Long id, CourseDto courseDto);
    void update(String title);
    void delete(Long id);
    void delete(String delete);
    Course view (Long id);
    List<Course> view();
    void publishCourse(Long id);



}
