package com.kavinda.examresult.service;

import com.kavinda.examresult.dto.requestDTO.Semester03ExamResultRequestDTO;
import com.kavinda.examresult.entity.Semester03ExamResult;

public interface Semester03Service {

    Semester03ExamResult addNewSemester03ExamResultWithStudentId(Semester03ExamResultRequestDTO semester03ExamResultRequestDTO);
}
