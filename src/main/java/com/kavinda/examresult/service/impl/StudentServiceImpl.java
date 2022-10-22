package com.kavinda.examresult.service.impl;

import com.kavinda.examresult.dto.requestDTO.StudentRequestDTO;
import com.kavinda.examresult.dto.responseDTO.StudentResponseDTO;
import com.kavinda.examresult.entity.Student;
import com.kavinda.examresult.repository.StudentRepository;
import com.kavinda.examresult.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Add new Student
    @Override
    public Student addNewStudent(StudentRequestDTO studentRequestDTO) {
        try {
            Student student = new Student(studentRequestDTO);
            return studentRepository.save(student);
        }catch (InternalError internalError){
            return null;
        }
    }

    // Retrieve all student details
    @Override
    public List<StudentResponseDTO> getAllStudentDetails() {
        try {
            return studentRepository.findAll().stream().map(this::mapStudentResponseDTO).collect(Collectors.toList());
        }catch (FileSystemNotFoundException fileSystemNotFoundException){
            return null;
        }
    }

    // Retrieve student details by student id
    @Override
    public Student getStudentDetailsById(Integer studentId) {
        try {
            return studentRepository.findById(studentId).get();
        }catch (FileSystemNotFoundException fileSystemNotFoundException){
            return null;
        }
    }

    // Retrieve student details by student index number
    @Override
    public Student getStudentDetailsByIndex(String studentIndex){
        try {
            return studentRepository.findAllByStudentIndex(studentIndex);
        }catch (FileSystemNotFoundException fileSystemNotFoundException){
            return null;
        }
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

