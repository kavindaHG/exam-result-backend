package com.kavinda.examresult.service.impl;

import com.kavinda.examresult.dto.requestDTO.StudentRequestDTO;
import com.kavinda.examresult.dto.responseDTO.StudentIndexAndNameResponseDTO;
import com.kavinda.examresult.dto.responseDTO.StudentResponseDTO;
import com.kavinda.examresult.entity.Student;
import com.kavinda.examresult.repository.StudentRepository;
import com.kavinda.examresult.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student retrieveStudentDetailsByStudentId(Integer studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public Student addNewStudent(StudentRequestDTO studentRequestDTO) {
        Student student = new Student(studentRequestDTO);
        return studentRepository.save(student);
    }

    @Override
    public Student retrieveStudentIndexAndNameByStudentIndexNumber(String studentIndex){
        return studentRepository.getByIndex(studentIndex);
    }

//    private StudentResponseDTO studentResponseDTO(Student student){
//        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
//        studentResponseDTO.setStudentIndex(student.getStudentIndex());
//        studentResponseDTO.setStudentName(student.getStudentName());
//        studentResponseDTO.setStudentBatch(student.getStudentBatch());
//        studentResponseDTO.setStudentDepartment(student.getStudentDepartment());
//        studentResponseDTO.setStudentEmail(student.getStudentEmail());
//        studentResponseDTO.setStudentMobile(student.getStudentMobile());
//        return studentResponseDTO;
//    }

}

