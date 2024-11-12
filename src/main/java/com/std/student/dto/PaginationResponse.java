package com.std.student.dto;

import com.std.student.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class PaginationResponse {
    private Integer totalPages;
    private Long totalRecords;
    private Integer noOfRecordsPerPage;
    private List<Student> students;
}
