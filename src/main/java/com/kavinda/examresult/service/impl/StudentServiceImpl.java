package com.kavinda.examresult.service.impl;

import com.kavinda.examresult.dto.requestDTO.StudentRequestDTO;
import com.kavinda.examresult.dto.responseDTO.StudentIndexAndName;
import com.kavinda.examresult.dto.responseDTO.StudentResponseDTO;
import com.kavinda.examresult.entity.Student;
import com.kavinda.examresult.repository.StudentRepository;
import com.kavinda.examresult.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addNewStudent(StudentRequestDTO studentRequestDTO) {
        Student student = new Student(studentRequestDTO);
        return studentRepository.save(student);
    }

    @Override
    public List<StudentResponseDTO> getAllStudentDetails() {
        return studentRepository.findAll().stream().map(this::mapStudentResponseDTO).collect(Collectors.toList());
    }

    @Override
    public Student getStudentDetailsById(Integer studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public Student getStudentDetailsByIndex(String studentIndex){
        return studentRepository.findAllByStudentIndex(studentIndex);
    }

    //Map StudentResponseDTO With Student Entity
    private StudentResponseDTO mapStudentResponseDTO(Student student){
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setStudentIndex(student.getStudentIndex());
        studentResponseDTO.setStudentName(student.getStudentName());
        studentResponseDTO.setStudentBatch(student.getStudentBatch());
        studentResponseDTO.setStudentDepartment(student.getStudentDepartment());
        studentResponseDTO.setStudentEmail(student.getStudentEmail());
        studentResponseDTO.setStudentMobile(student.getStudentMobile());
        return studentResponseDTO;
    }

}

