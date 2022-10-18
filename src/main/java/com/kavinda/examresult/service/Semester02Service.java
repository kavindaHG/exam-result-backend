package com.kavinda.examresult.service;

import com.kavinda.examresult.dto.requestDTO.Semester02ExamResultRequestDTO;
import com.kavinda.examresult.entity.Semester02ExamResult;

public interface Semester02Service {

    Semester02ExamResult addNewSemester02ExamResultWithStudentId(Semester02ExamResultRequestDTO semester02ExamResultRequestDTO);
}
