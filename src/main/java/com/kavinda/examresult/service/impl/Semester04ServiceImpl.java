package com.kavinda.examresult.service.impl;

import com.kavinda.examresult.dto.requestDTO.Sem04ResultResponseDTO;
import com.kavinda.examresult.entity.Sem04ExamResult;
import com.kavinda.examresult.entity.Student;
import com.kavinda.examresult.repository.Semester04Repository;
import com.kavinda.examresult.service.Semester04Service;
import com.kavinda.examresult.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Semester04ServiceImpl implements Semester04Service {

    @Autowired
    private Semester04Repository semester04Repository;

    @Autowired
    private StudentService studentService;

    @Override
    public Sem04ExamResult newSemester04ExamResult(Sem04ResultResponseDTO sem04ResultResponseDTO) {
        Student studentId = studentService.getStudentDetailsById(sem04ResultResponseDTO.getStudentId());
        Sem04ExamResult semester04ExamResult = new Sem04ExamResult(sem04ResultResponseDTO, studentId);
        return semester04Repository.save(semester04ExamResult);
    }
}
