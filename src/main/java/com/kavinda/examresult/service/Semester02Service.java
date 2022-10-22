package com.kavinda.examresult.service;

import com.kavinda.examresult.dto.requestDTO.Sem02ResultRequestDTO;
import com.kavinda.examresult.dto.responseDTO.Sem02ResultResponseDTO;
import com.kavinda.examresult.entity.Sem02ExamResult;

import java.util.List;

public interface Semester02Service {

    Sem02ExamResult newSemester02ExamResult(Sem02ResultRequestDTO semester02ExamResultRequestDTO);

    List<Sem02ResultResponseDTO> retrieveSem02AllResult();

    List<Sem02ResultResponseDTO> retrieveSem02ResultByIndex(String studentIndex);
}
