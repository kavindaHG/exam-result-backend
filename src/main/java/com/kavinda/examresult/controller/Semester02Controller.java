package com.kavinda.examresult.controller;

import com.kavinda.examresult.common.ExamResultConstants;
import com.kavinda.examresult.dto.requestDTO.Semester02ExamResultRequestDTO;
import com.kavinda.examresult.entity.Semester02ExamResult;
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

    @PostMapping("/")
    public Semester02ExamResult addNewSemester02ExamResultWithStudentId(@RequestBody Semester02ExamResultRequestDTO
                                                                                    semester02ExamResultRequestDTO){
        return semester02Service.addNewSemester02ExamResultWithStudentId(semester02ExamResultRequestDTO);
    }
}
