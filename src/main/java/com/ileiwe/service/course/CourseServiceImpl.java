package com.ileiwe.service.course;

import com.ileiwe.data.dto.CourseDoesNotExistException;
import com.ileiwe.data.dto.CourseDto;
import com.ileiwe.data.model.Course;
import com.ileiwe.data.model.Instructor;
import com.ileiwe.data.repository.CourseRepository;
import com.ileiwe.data.repository.InstructorRepository;
import com.ileiwe.service.mapper.CourseMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j

public class CourseServiceImpl implements CourseService {

    @Autowired
    InstructorRepository instructorRepository;
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseMapper courseMapper;

    public CourseServiceImpl(){

    }
    @Override
    @Transactional
    public Course create(CourseDto courseDto, Long id) {
        Instructor instructor = instructorRepository.findById(id).get();
            log.info("course Dt0 before saving {}", courseDto);
        log.info("Instructor before saving {}", instructor);


        Course course = new Course();
            course.setTitle(courseDto.getTitle());
            course.setDescription(courseDto.getDescription());
            course.setLanguage(courseDto.getLanguage());
            course.setInstructor(instructor);
            course.setImageUrls(courseDto.getImageUrls());
            course.setDuration(courseDto.getDuration());

            courseRepository.save(course);

        log.info("course after saving {}", course);
        log.info("Instructor after saving {}", instructor);

        return course;




        }

    @Override
    public Course update(Long id, CourseDto courseDto) {

        if (courseDto == null) {
            throw new NullPointerException("Course is not present");
        }
            Optional<Course> result = courseRepository.findById(id);
            if (result.isPresent()) {
                Course course = result.get();
                courseMapper.mapDtoToCourse(courseDto, course);
                return courseRepository.save(course);
            } else throw new CourseDoesNotExistException("Wrong course");


        }



//    Optional<Product> result = productRepository.findById(id);
//        if(result.isPresent()){
//        Product product = result.get();
//        productMapper.mapDtoToProduct(productDto, product);
//        return productRepository.save(product);

//    public void updateLocation(String id, Location location) {
//
//        for(int i = 0; i < locations.size(); i++) {
//
//            Location l = locations.get(i);
//
//            if (l.getId().equals(id)) {
//                locations.set(i, location);
//            }

    @Override
    public void update(String title) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(String delete) {

    }

    @Override
    public Course view(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Course> view() {
        return  courseRepository.findAll();
    }


    @Override
    public void publishCourse(Long id) {

    }
}
