package com.ileiwe.service.mapper;

import com.ileiwe.data.dto.CourseDto;
import com.ileiwe.data.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.BeanMapping;

import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.context.annotation.Bean;


@Mapper(componentModel = "spring")

public interface CourseMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapDtoToCourse(CourseDto courseDto, @MappingTarget Course course);
}
