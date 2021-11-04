package com.ileiwe.data.dto;

import com.ileiwe.data.model.Instructor;
import lombok.Data;

import java.util.List;

@Data
public class CourseDto {
    private String title;
    private String description;
    private String language;
    private List<String> imageUrls;
    private Instructor instructor;
    private String duration;

}
