package com.kavinda.examresult.controller;

import com.kavinda.examresult.common.ExamResultConstants;
import com.kavinda.examresult.dto.requestDTO.StudentRequestDTO;
import com.kavinda.examresult.dto.responseDTO.StudentResponseDTO;
import com.kavinda.examresult.entity.Student;
import com.kavinda.examresult.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ExamResultConstants.STUDENT_BASE_URL)
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Add new student details
    @PostMapping("/new")
    public Student addNewStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        return studentService.addNewStudent(studentRequestDTO);
    }

    // Retrieve all student details
    @GetMapping("/all")
    public List<StudentResponseDTO> getAllStudentDetails (){
        return studentService.getAllStudentDetails();
    }

    // Retrieve student details by student ID
    @GetMapping("/:id/{id}")
    public Student getStudentById(@PathVariable ("id") Integer studentId){
        return studentService.getStudentDetailsById(studentId);
    }

    // Retrieve student details by student Index
    @GetMapping("/:index/{index}")
    public Student getStudentByIndex(@PathVariable ("index") String studentIndex){
        return studentService.getStudentDetailsByIndex(studentIndex);
    }
}
