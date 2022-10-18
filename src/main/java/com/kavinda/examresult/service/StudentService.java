package com.kavinda.examresult.service;

import com.kavinda.examresult.dto.requestDTO.StudentRequestDTO;
import com.kavinda.examresult.dto.responseDTO.StudentIndexAndNameResponseDTO;
import com.kavinda.examresult.dto.responseDTO.StudentResponseDTO;
import com.kavinda.examresult.entity.Student;

public interface StudentService {

    Student retrieveStudentDetailsByStudentId(Integer studentId);

    Student addNewStudent(StudentRequestDTO studentRequestDTO);

    Student retrieveStudentIndexAndNameByStudentIndexNumber(String studentIndex);
}
