package com.std.student.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student_results")
public class StudentResults {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_results_id;

    private String subject_name;

    private String marks;

}
