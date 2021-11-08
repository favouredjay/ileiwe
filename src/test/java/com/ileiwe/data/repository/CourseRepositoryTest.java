package com.ileiwe.data.repository;

import com.ileiwe.data.dto.CourseDto;
import com.ileiwe.data.model.Course;
import com.ileiwe.service.course.CourseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Service
@SpringBootTest
@Slf4j
class CourseRepositoryTest {

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseServiceImpl courseService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createCourseTable(){
        CourseDto courseDto = new CourseDto();
//        courseDto.setTitle("Once");
//        courseDto.setDescription("Once");
//        courseDto.setDuration("30 mins");
//        assertThat(courseRepository.findAll().size()).isEqualTo(1);
//        courseService.create(courseDto, 1L);
//        assertThat()

    }


}