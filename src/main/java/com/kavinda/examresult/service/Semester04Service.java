package com.kavinda.examresult.service;

import com.kavinda.examresult.dto.requestDTO.Sem04ResultRequestDTO;
import com.kavinda.examresult.dto.responseDTO.Sem04ResultResponseDTO;
import com.kavinda.examresult.entity.Sem04ExamResult;

import java.util.List;

public interface Semester04Service {

    Sem04ExamResult newSemester04ExamResult(Sem04ResultRequestDTO sem04ResultRequestDTO);

    List<Sem04ResultResponseDTO> retrieveSem04AllResult();

    List<Sem04ResultResponseDTO> retrieveSem02ResultByIndex(String studentIndex);
}
