package com.ileiwe.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author oluwatobi
 * @version 1.0
 * @date on 27/10/2021
 * inside the package - com.ileiwe.data.model
 */

@Slf4j
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToOne(cascade = CascadeType.PERSIST)
    private LearningParty learningParty;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Course> enrolledCourses;

    public void addCourse(Course course) {
        if(enrolledCourses == null){
            enrolledCourses = new ArrayList<>();
        }
        for(Course course1: enrolledCourses){
            if(course1.getId().equals(course.getId()))
                return;
        }
        enrolledCourses.add(course);
    }

}
