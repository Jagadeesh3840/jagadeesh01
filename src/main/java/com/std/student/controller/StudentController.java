package com.std.student.controller;

import com.std.student.Constants;
import com.std.student.dto.PaginationResponse;
import com.std.student.dto.StudentDTO;
import com.std.student.entity.Student;
import com.std.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.StudentEndPoints.BASE_END_POINT)
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @PostMapping
    public ResponseEntity saveStudentDetails(@RequestBody StudentDTO studentDTO){
        Student studentDetails = studentService.saveStudentDetails(studentDTO);
        return ResponseEntity.ok(studentDetails);
    }

    @GetMapping
    public ResponseEntity findAllStudents(@RequestParam Integer pageNumber, @RequestParam Integer pageSize,
                                          @RequestParam(required = false) String sortBy){
        PaginationResponse students =  studentService.findAllStudents(pageNumber, pageSize, sortBy);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity findStudent(@PathVariable Long studentId){
        Student students =  studentService.findStudent(studentId);
        return ResponseEntity.ok(students);
    }
    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student deleted successfully");
    }

}
