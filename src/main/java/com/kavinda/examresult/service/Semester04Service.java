package com.kavinda.examresult.service;

import com.kavinda.examresult.dto.requestDTO.Semester04ExamResultRequestDTO;
import com.kavinda.examresult.entity.Semester04ExamResult;

import java.util.List;

public interface Semester04Service {

    Semester04ExamResult addNewSemester04ExamResultWithStudentId(Semester04ExamResultRequestDTO semester04ExamResultRequestDTO);
}
