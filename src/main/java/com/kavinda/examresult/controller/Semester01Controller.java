package com.kavinda.examresult.controller;

import com.kavinda.examresult.common.ExamResultConstants;
import com.kavinda.examresult.dto.requestDTO.Sem01ResultRequestDTO;
import com.kavinda.examresult.dto.responseDTO.Sem01ResultResponseDTO;
import com.kavinda.examresult.entity.Sem01ExamResult;
import com.kavinda.examresult.service.Semester01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ExamResultConstants.SEMESTER_01_BASE_URL)
public class Semester01Controller {

    @Autowired
    private Semester01Service semester01Service;

    //Add new semester 01 exam result using student ID
    @PostMapping("/semester-01-result")
    public Sem01ExamResult newSem01Result(@RequestBody Sem01ResultRequestDTO
                                                  sem01ResultRequestDTO){
        return semester01Service.newSemester01ExamResult(sem01ResultRequestDTO);
    }

    //retrieve semester 01 exam result by student index with student index and name
    @GetMapping("/semester-01-result")
    public List<Sem01ResultResponseDTO> getSem01AllResult(){
        return semester01Service.retrieveSemester01ExamResults();
    }
}
