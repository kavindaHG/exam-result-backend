package com.kavinda.examresult.service;

import com.kavinda.examresult.dto.requestDTO.Sem03ResultRequestDTO;
import com.kavinda.examresult.dto.responseDTO.Sem03ResultResponseDTO;
import com.kavinda.examresult.entity.Sem03ExamResult;

import java.util.List;

public interface Semester03Service {

    Sem03ExamResult newSemester03ExamResult(Sem03ResultRequestDTO sem03ResultRequestDTO);

    List<Sem03ResultResponseDTO> retrieveSem03AllResult();

    List<Sem03ResultResponseDTO> retrieveSem03ResultByIndex(String studentIndex);
}
