package com.std.student.controller;

import com.std.student.dto.StudentDTO;
import com.std.student.service.StreamService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/streams")
@AllArgsConstructor
public class StreamController {

    StreamService streamService;

    @GetMapping("/failed")
    public ResponseEntity<List> getFailedStudents(@RequestBody List<StudentDTO> list) {
        List failedStudents = streamService.getFailedStudents(list);
        return ResponseEntity.ok(failedStudents);
    }

    @GetMapping("/limit")
    public void getPassedStudents(@RequestBody List<StudentDTO> list) {
        streamService.getPassedStudentsInLimit(list);
    }

    @GetMapping("/reduce")
    public ResponseEntity<Integer> getStudentsTotalMarks(@RequestBody List<StudentDTO> list) {
        return ResponseEntity.ok(streamService.reduce(list));
    }

    @GetMapping("/toMap")
    public ResponseEntity<Map> toMap(@RequestBody List<StudentDTO> list) {
        return ResponseEntity.ok(streamService.toMap(list));
    }

    @GetMapping("/sum")
    public ResponseEntity<Long> getSumOfMarks(@RequestBody List<StudentDTO> list) {
        return ResponseEntity.ok(streamService.getSumOfMarks(list));
    }

    @GetMapping("/groupBy")
    public ResponseEntity<Map> groupBy(@RequestBody List<StudentDTO> list) {
        return ResponseEntity.ok(streamService.groupBy(list));
    }
}
