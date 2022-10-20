package com.kavinda.examresult.service.impl;

import com.kavinda.examresult.dto.requestDTO.Sem03ResultResponseDTO;
import com.kavinda.examresult.entity.Sem03ExamResult;
import com.kavinda.examresult.entity.Student;
import com.kavinda.examresult.repository.Semester03Repository;
import com.kavinda.examresult.service.Semester03Service;
import com.kavinda.examresult.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Semester03ServiceImpl implements Semester03Service {

    @Autowired
    private Semester03Repository semester03Repository;

    @Autowired
    private StudentService studentService;

    @Override
    public Sem03ExamResult newSemester03ExamResult(Sem03ResultResponseDTO sem03ResultResponseDTO) {
        Student studentId = studentService.getStudentDetailsById(sem03ResultResponseDTO.getStudentId());
        Sem03ExamResult sem03ExamResult = new Sem03ExamResult(sem03ResultResponseDTO, studentId);
        return semester03Repository.save(sem03ExamResult);
    }
}
