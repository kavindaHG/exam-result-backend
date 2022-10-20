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

    //add new student details
    @PostMapping("/student")
    public Student addNewStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        return studentService.addNewStudent(studentRequestDTO);
    }

    //get all student details
    @GetMapping("/student")
    public List<StudentResponseDTO> getAllStudentDetails (){
        return studentService.getAllStudentDetails();
    }

    //retrieve student details by student ID
    @GetMapping("student-by-id/{id}")
    public Student getStudentById(@PathVariable ("id") Integer studentId){
        return studentService.getStudentDetailsById(studentId);
    }

    //retrieve student details by student Index
    @GetMapping("student-by-index/{index}")
    public Student getStudentByIndex(@PathVariable ("index") String studentIndex){
        return studentService.getStudentDetailsByIndex(studentIndex);
    }
}
