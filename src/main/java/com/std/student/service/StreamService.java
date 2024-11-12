package com.std.student.service;

import com.std.student.dto.StudentDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StreamService {

    public List getFailedStudents(List<StudentDTO> list){
        return list.stream().filter(rec -> rec.getMarks() < 60).collect(Collectors.toList());
    }

    public void getPassedStudentsInLimit(List<StudentDTO> list){
        list.stream().filter(rec -> rec.getMarks() > 60).limit(2).forEach(System.out::println);
    }

    public Integer reduce(List<StudentDTO> list){
        return list.stream().map(StudentDTO::getMarks).reduce(0, Integer::sum);
    }

    public Map<String, String> toMap(List<StudentDTO> list){
//         list.stream().limit(2).collect(Collectors.toMap(res -> res.getStudentName(),res -> res.getMobileNumber()));
        return  list.stream().filter(res -> res.getMarks() > 50).collect(Collectors.toMap(StudentDTO::getStudentName,StudentDTO::getMobileNumber));
    }

    public Long getSumOfMarks(List<StudentDTO> list){
        //summingInt()
        return list.stream().mapToLong(StudentDTO::getMarks).sum();
    }

    public Map groupBy(List<StudentDTO> list){
        return list.stream().collect(Collectors.groupingBy(StudentDTO::getStudentName));
    }
}
