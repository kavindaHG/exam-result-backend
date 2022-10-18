package com.kavinda.examresult.controller;

import com.kavinda.examresult.common.ExamResultConstants;
import com.kavinda.examresult.dto.requestDTO.Semester03ExamResultRequestDTO;
import com.kavinda.examresult.entity.Semester03ExamResult;
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

    @PostMapping("/")
    public Semester03ExamResult addNewSemester03ExamResultWithStudentId(@RequestBody Semester03ExamResultRequestDTO
                                                                                    semester03ExamResultRequestDTO){
        return semester03Service.addNewSemester03ExamResultWithStudentId(semester03ExamResultRequestDTO);
    }
}
