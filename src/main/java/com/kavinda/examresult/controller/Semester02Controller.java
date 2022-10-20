package com.kavinda.examresult.controller;

import com.kavinda.examresult.common.ExamResultConstants;
import com.kavinda.examresult.dto.requestDTO.Sem02ResultResponseDTO;
import com.kavinda.examresult.entity.Sem02ExamResult;
import com.kavinda.examresult.service.Semester02Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ExamResultConstants.SEMESTER_02_BASE_URL)
public class Semester02Controller {

    @Autowired
    private Semester02Service semester02Service;

    //Add new semester 01 exam result using student ID
    @PostMapping("/semester-02-result")
    public Sem02ExamResult newSem02Result(@RequestBody Sem02ResultResponseDTO
                                                                                    semester02ExamResultRequestDTO){
        return semester02Service.newSemester02ExamResult(semester02ExamResultRequestDTO);
    }
}
