package com.kavinda.examresult.service;

import com.kavinda.examresult.dto.requestDTO.Semester01ExamResultRequestDTO;
import com.kavinda.examresult.dto.responseDTO.Semester01ExamResultResponseDTO;
import com.kavinda.examresult.entity.Semester01ExamResult;

import java.util.List;

public interface Semester01Service {
    Semester01ExamResult addNewSemester01ExamResultWithStudentId(Semester01ExamResultRequestDTO semester01ExamResultRequestDTO);

    List<Semester01ExamResultResponseDTO> retrieveAllSemester01ExamResultsWithStudentIndexAndName();
}
