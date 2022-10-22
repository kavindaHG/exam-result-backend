package com.kavinda.examresult.service;

import com.kavinda.examresult.dto.requestDTO.Sem01ResultRequestDTO;
import com.kavinda.examresult.dto.responseDTO.Sem01ResultResponseDTO;
import com.kavinda.examresult.entity.Sem01ExamResult;

import java.util.List;

public interface Semester01Service {
    Sem01ExamResult newSemester01ExamResult(Sem01ResultRequestDTO sem01ResultRequestDTO);

    List<Sem01ResultResponseDTO> retrieveSem01AllResult();

    List<Sem01ResultResponseDTO> retrieveSem01ResultByIndex(String studentIndex);
}
