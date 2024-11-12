package com.std.student.service;

import com.mysql.cj.util.StringUtils;
import com.std.student.dto.PaginationResponse;
import com.std.student.dto.StudentDTO;
import com.std.student.entity.Student;
import com.std.student.entity.StudentResults;
import com.std.student.repository.StudentPaginationRepo;
import com.std.student.repository.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService {

    private StudentRepo studentRepo;

    private StudentPaginationRepo paginationRepo;

    public Student saveStudentDetails(StudentDTO studentDTO) {
        Student student = new Student();
        student.setStudent_name(studentDTO.getStudentName());
        student.setEmail(studentDTO.getEmail());
        student.setAddress(studentDTO.getAddress());
        student.setMarks(studentDTO.getMarks());
        student.setMobile_number(studentDTO.getMobileNumber());
        List<StudentResults> results = new ArrayList<>();

        studentDTO.getStudentResults().forEach(res -> {
            StudentResults result = new StudentResults();
            result.setMarks(res.getMarks());
            result.setSubject_name(res.getSubjectName());
            results.add(result);
        });
        student.setResults(results);
        return studentRepo.save(student);
    }

    public PaginationResponse findAllStudents(Integer pageNumber, Integer pageSize, String sortBy) {
        if (StringUtils.isNullOrEmpty(sortBy)){
            sortBy = "id";
        }
        Page<Student> studentPage = paginationRepo.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending()));
        PaginationResponse paginationResponse = new PaginationResponse();
        paginationResponse.setNoOfRecordsPerPage(studentPage.getSize());
        paginationResponse.setTotalPages(studentPage.getTotalPages());
        paginationResponse.setTotalRecords(studentPage.getTotalElements());

        List<Student> studentsList = studentPage.stream().map(rec -> {
            Student student = new Student();
            student.setStudent_name(rec.getStudent_name());
            student.setId(rec.getId());
            student.setResults(rec.getResults());
            student.setEmail(rec.getEmail());
            student.setMobile_number(rec.getMobile_number());
            return student;
        }).collect(Collectors.toList());
        paginationResponse.setStudents(studentsList);
        return paginationResponse;
    }

    public Student findStudent(Long studentId) {
        Optional<Student> optionalStudent = studentRepo.findById(studentId);
        return optionalStudent.orElse(null);
    }

    public void deleteStudent(Long studentId) {
        studentRepo.deleteById(studentId);
    }
}
