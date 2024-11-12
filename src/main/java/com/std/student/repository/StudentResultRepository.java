package com.std.student.repository;

import com.std.student.entity.StudentResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentResultRepository extends JpaRepository<StudentResults, Long> {
}
