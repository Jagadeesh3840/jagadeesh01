package com.std.student.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class StudentDTO {

    @NotEmpty(message = "StudentName should not be empty")
    private String studentName;

    @NotEmpty(message = "mobileNumber should not be empty")
    private String mobileNumber;

    @NotEmpty(message = "email should not be empty")
    private String email;

    @NotNull(message = "marks should not be null")
    private Integer marks;

    @NotEmpty(message = "address should not be empty")
    private String address;

//    @NotBlank(message = "studentResults should not be empty")
    private Set<StudentResultsDTO> studentResults;
}
