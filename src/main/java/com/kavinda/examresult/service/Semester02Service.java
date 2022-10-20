package com.kavinda.examresult.service;

import com.kavinda.examresult.dto.requestDTO.Sem02ResultResponseDTO;
import com.kavinda.examresult.entity.Sem02ExamResult;

public interface Semester02Service {

    Sem02ExamResult newSemester02ExamResult(Sem02ResultResponseDTO semester02ExamResultRequestDTO);
}
