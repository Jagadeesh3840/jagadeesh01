package com.std.student.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentResultsDTO {

    @NotEmpty(message = "subjectName should not be empty")
    private String subjectName;

    @NotNull(message = "Marks should not be null")
    private String marks;

}
