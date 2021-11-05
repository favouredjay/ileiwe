package com.ileiwe.service.mapper;


import com.ileiwe.data.dto.StudentDto;

import com.ileiwe.data.model.Student;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public class StudentMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mapDtoToStudent(StudentDto studentDto, @MappingTarget Student student) {

    }
}
