package com.kavinda.examresult.controller;

import com.kavinda.examresult.common.ExamResultConstants;
import com.kavinda.examresult.dto.requestDTO.Semester01ExamResultRequestDTO;
import com.kavinda.examresult.dto.responseDTO.Semester01ExamResultResponseDTO;
import com.kavinda.examresult.entity.Semester01ExamResult;
import com.kavinda.examresult.service.Semester01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ExamResultConstants.SEMESTER_01_BASE_URL)
public class Semester01Controller {

    @Autowired
    private Semester01Service semester01Service;

    @PostMapping("/")
    public Semester01ExamResult addNewSemester01ExamResultWithStudentId(@RequestBody Semester01ExamResultRequestDTO
                                                                                    semester01ExamResultRequestDTO){
        return semester01Service.addNewSemester01ExamResultWithStudentId(semester01ExamResultRequestDTO);
    }

    @GetMapping("/")
    public List<Semester01ExamResultResponseDTO> retrieveAllSemester01ExamResultsWithStudentIndexAndName(){
        return semester01Service.retrieveAllSemester01ExamResultsWithStudentIndexAndName();
    }
}
