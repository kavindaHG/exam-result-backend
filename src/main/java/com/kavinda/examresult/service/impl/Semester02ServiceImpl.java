package com.kavinda.examresult.service.impl;

import com.kavinda.examresult.dto.requestDTO.Semester02ExamResultRequestDTO;
import com.kavinda.examresult.entity.Semester02ExamResult;
import com.kavinda.examresult.entity.Student;
import com.kavinda.examresult.repository.Semester02Repository;
import com.kavinda.examresult.service.Semester02Service;
import com.kavinda.examresult.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Semester02ServiceImpl implements Semester02Service {

    @Autowired
    private Semester02Repository semester02Repository;

    @Autowired
    private StudentService studentService;

    @Override
    public Semester02ExamResult addNewSemester02ExamResultWithStudentId(Semester02ExamResultRequestDTO
                                                                                    semester02ExamResultRequestDTO) {
        Student studentId = studentService.retrieveStudentDetailsByStudentId(semester02ExamResultRequestDTO.getStudentId());
        Semester02ExamResult semester02ExamResult = new Semester02ExamResult(semester02ExamResultRequestDTO, studentId);
        return semester02Repository.save(semester02ExamResult);
        }
}
