package com.kavinda.examresult.service.impl;

import com.kavinda.examresult.dto.requestDTO.Semester04ExamResultRequestDTO;
import com.kavinda.examresult.entity.Semester02ExamResult;
import com.kavinda.examresult.entity.Semester04ExamResult;
import com.kavinda.examresult.entity.Student;
import com.kavinda.examresult.repository.Semester03Repository;
import com.kavinda.examresult.repository.Semester04Repository;
import com.kavinda.examresult.service.Semester03Service;
import com.kavinda.examresult.service.Semester04Service;
import com.kavinda.examresult.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Semester04ServiceImpl implements Semester04Service {

    @Autowired
    private Semester04Repository semester04Repository;

    @Autowired
    private StudentService studentService;

    @Override
    public Semester04ExamResult addNewSemester04ExamResultWithStudentId(Semester04ExamResultRequestDTO semester04ExamResultRequestDTO) {
        Student studentId = studentService.retrieveStudentDetailsByStudentId(semester04ExamResultRequestDTO.getStudentId());
        Semester04ExamResult semester04ExamResult = new Semester04ExamResult(semester04ExamResultRequestDTO, studentId);
        return semester04Repository.save(semester04ExamResult);
    }
}
