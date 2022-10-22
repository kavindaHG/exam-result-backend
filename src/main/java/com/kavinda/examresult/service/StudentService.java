package com.kavinda.examresult.service;

import com.kavinda.examresult.dto.requestDTO.StudentRequestDTO;
import com.kavinda.examresult.dto.responseDTO.StudentResponseDTO;
import com.kavinda.examresult.entity.Student;

import java.util.List;


public interface StudentService {
    Student addNewStudent(StudentRequestDTO studentRequestDTO);

    List<StudentResponseDTO> getAllStudentDetails();

    Student getStudentDetailsById(Integer studentId);

    Student getStudentDetailsByIndex(String studentIndex);
}
