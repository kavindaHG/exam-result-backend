package com.kavinda.examresult.controller;

import com.kavinda.examresult.common.ExamResultConstants;
import com.kavinda.examresult.dto.requestDTO.Sem02ResultRequestDTO;
import com.kavinda.examresult.dto.responseDTO.Sem02ResultResponseDTO;
import com.kavinda.examresult.entity.Sem02ExamResult;
import com.kavinda.examresult.service.Semester02Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ExamResultConstants.SEMESTER_02_BASE_URL)
public class Semester02Controller {

    @Autowired
    private Semester02Service semester02Service;

    // Add new semester 01 exam result using student Index Number
    @PostMapping("/new-result")
    public Sem02ExamResult newSem02Result(@RequestBody Sem02ResultRequestDTO sem02ResultRequestDTO){
        return semester02Service.newSemester02ExamResult(sem02ResultRequestDTO);
    }

    // Retrieve All semester 01 exam result by student index with student index and name
    @GetMapping("/all-student-result")
    public List<Sem02ResultResponseDTO> retrieveSem02AllResult(){
        return semester02Service.retrieveSem02AllResult();
    }

    // Retrieve semester 01 exam result and student details by student index number
    @GetMapping("/result-by-index/{index}")
    public List<Sem02ResultResponseDTO> retrieveSem02ResultByIndex(@PathVariable ("index") String studentIndex){
        return semester02Service.retrieveSem02ResultByIndex(studentIndex);
    }
}
