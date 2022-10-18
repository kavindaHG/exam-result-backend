package com.kavinda.examresult.controller;

import com.kavinda.examresult.common.ExamResultConstants;
import com.kavinda.examresult.dto.requestDTO.StudentRequestDTO;
import com.kavinda.examresult.dto.responseDTO.StudentIndexAndNameResponseDTO;
import com.kavinda.examresult.dto.responseDTO.StudentResponseDTO;
import com.kavinda.examresult.entity.Student;
import com.kavinda.examresult.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ExamResultConstants.STUDENT_BASE_URL)
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public Student addNewStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        return studentService.addNewStudent(studentRequestDTO);
    }

    @GetMapping("/id/{id}")
    public Student retrieveStudentDetailsByStudentId(@PathVariable ("id") Integer studentId){
        return studentService.retrieveStudentDetailsByStudentId(studentId);
    }

    @GetMapping("/index/{index}")
    public Student retrieveStudentIndexAndNameByStudentIndexNumber(@PathVariable ("index") String studentIndex){
        return studentService.retrieveStudentIndexAndNameByStudentIndexNumber(studentIndex);
    }
}
