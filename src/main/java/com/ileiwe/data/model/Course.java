package com.ileiwe.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author oluwatobi
 * @version 1.0
 * @date on 27/10/2021
 * inside the package - com.ileiwe.data.model
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(length = 1000)
    private String description;
    private String duration;
    private String language;
    @ElementCollection
    private List<String> imageUrls;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    private LocalDateTime datePublished;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private boolean isPublished;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Instructor instructor;
    @ManyToMany
    private List<Student> students;

    public void addStudent(Student student) {
        if(students == null){
            students = new ArrayList<>();
        }
        for(Student student1: students){
            if(student.getId().equals(student1.getId())){
                return;
            }
        }
        students.add(student);
    }

}
