package com.kavinda.examresult.controller;

import com.kavinda.examresult.common.ExamResultConstants;
import com.kavinda.examresult.dto.requestDTO.Sem03ResultResponseDTO;
import com.kavinda.examresult.entity.Sem03ExamResult;
import com.kavinda.examresult.service.Semester03Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ExamResultConstants.SEMESTER_03_BASE_URL)
public class Semester03Controller {

    @Autowired
    private Semester03Service semester03Service;

    //Add new semester 03 exam result using student ID
    @PostMapping("/semester-03-result")
    public Sem03ExamResult newSem03Result(@RequestBody Sem03ResultResponseDTO
                                                  sem03ResultResponseDTO){
        return semester03Service.newSemester03ExamResult(sem03ResultResponseDTO);
    }
}
