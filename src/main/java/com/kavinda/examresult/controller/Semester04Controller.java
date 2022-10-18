package com.kavinda.examresult.controller;

import com.kavinda.examresult.common.ExamResultConstants;
import com.kavinda.examresult.dto.requestDTO.Semester04ExamResultRequestDTO;
import com.kavinda.examresult.entity.Semester04ExamResult;
import com.kavinda.examresult.service.Semester04Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ExamResultConstants.SEMESTER_04_BASE_URL)
public class Semester04Controller {

    @Autowired
    private Semester04Service semester04Service;

    @PostMapping("/")
    public Semester04ExamResult addNewSemester04ExamResultWithStudentId(@RequestBody Semester04ExamResultRequestDTO
                                                                                    semester04ExamResultRequestDTO){
        return semester04Service.addNewSemester04ExamResultWithStudentId(semester04ExamResultRequestDTO);
    }
}
