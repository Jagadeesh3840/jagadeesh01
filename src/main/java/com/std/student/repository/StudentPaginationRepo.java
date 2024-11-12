package com.std.student.repository;

import com.std.student.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentPaginationRepo extends PagingAndSortingRepository<Student, Long> {
}
