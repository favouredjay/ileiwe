package com.ileiwe.service.course;

import com.ileiwe.data.dto.CourseDto;
import com.ileiwe.data.model.Course;

import java.util.List;

public interface CourseService {
    Course create(CourseDto courseDto, Long id);
    Course update(Long id, CourseDto courseDto);
    void delete(Long id);
    Course view (Long id);
    List<Course> view();
    Course publishCourse(Long courseId, Long instructorId);



}
