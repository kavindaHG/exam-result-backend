package com.kavinda.examresult.controller;

import com.kavinda.examresult.common.ExamResultConstants;
import com.kavinda.examresult.dto.requestDTO.Sem04ResultResponseDTO;
import com.kavinda.examresult.entity.Sem04ExamResult;
import com.kavinda.examresult.service.Semester04Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ExamResultConstants.SEMESTER_04_BASE_URL)
public class Semester04Controller {

    @Autowired
    private Semester04Service semester04Service;

    //Add new semester 04 exam result using student ID
    @PostMapping("/semester-04-result")
    public Sem04ExamResult newSem04Result(@RequestBody Sem04ResultResponseDTO
                                                  sem04ResultResponseDTO){
        return semester04Service.newSemester04ExamResult(sem04ResultResponseDTO);
    }
}
