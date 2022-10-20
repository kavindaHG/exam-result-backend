package com.kavinda.examresult.service.impl;

import com.kavinda.examresult.dto.requestDTO.Sem02ResultResponseDTO;
import com.kavinda.examresult.entity.Sem02ExamResult;
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
    public Sem02ExamResult newSemester02ExamResult(Sem02ResultResponseDTO
                                                                                    semester02ExamResultRequestDTO) {
        Student studentId = studentService.getStudentDetailsById(semester02ExamResultRequestDTO.getStudentId());
        Sem02ExamResult sem02ExamResult = new Sem02ExamResult(semester02ExamResultRequestDTO, studentId);
        return semester02Repository.save(sem02ExamResult);
        }
}
