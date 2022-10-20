package com.kavinda.examresult.service;

import com.kavinda.examresult.dto.requestDTO.Sem03ResultResponseDTO;
import com.kavinda.examresult.entity.Sem03ExamResult;

public interface Semester03Service {

    Sem03ExamResult newSemester03ExamResult(Sem03ResultResponseDTO sem03ResultResponseDTO);
}
