package com.kavinda.examresult.service.impl;

import com.kavinda.examresult.dto.requestDTO.Semester03ExamResultRequestDTO;
import com.kavinda.examresult.entity.Semester03ExamResult;
import com.kavinda.examresult.entity.Student;
import com.kavinda.examresult.repository.Semester01Repository;
import com.kavinda.examresult.repository.Semester03Repository;
import com.kavinda.examresult.service.Semester01Service;
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
    public Semester03ExamResult addNewSemester03ExamResultWithStudentId(Semester03ExamResultRequestDTO semester03ExamResultRequestDTO) {
        Student studentId = studentService.retrieveStudentDetailsByStudentId(semester03ExamResultRequestDTO.getStudentId());
        Semester03ExamResult semester03ExamResult = new Semester03ExamResult(semester03ExamResultRequestDTO, studentId);
        return semester03Repository.save(semester03ExamResult);
    }
}
