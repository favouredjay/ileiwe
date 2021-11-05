package com.ileiwe.controller;

import com.ileiwe.data.dto.InstructorPartyDto;
import com.ileiwe.data.dto.StudentDto;
import com.ileiwe.service.instructor.InstructorServiceImpl;
import com.ileiwe.service.student.StudentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author oluwatobi
 * @version 1.0
 * @date on 29/10/2021
 * inside the package - com.ileiwe.controller
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class RegistrationController {

    @Autowired
    InstructorServiceImpl instructorService;

    @Autowired
    StudentServiceImpl studentService;

    @PostMapping("/instructor")
    public ResponseEntity<?>
        registerAsInstructor(@RequestBody
                                    InstructorPartyDto
                             instructorPartyDto){
        log.info("instructor object --> {}", instructorPartyDto);
       return
           ResponseEntity.ok()
        .body(instructorService.save(instructorPartyDto));
    }

    @PostMapping("/student")
    public ResponseEntity<?>
    registerAsStudent(@RequestBody
                                 StudentDto
                                 studentDto){
        log.info("instructor object --> {}", studentDto);
        return
                ResponseEntity.ok()
                        .body(studentService.createStudent(studentDto));
    }
}
