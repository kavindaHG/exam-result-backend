package com.kavinda.examresult.controller;

import com.kavinda.examresult.common.ExamResultConstants;
import com.kavinda.examresult.dto.requestDTO.Sem03ResultRequestDTO;
import com.kavinda.examresult.dto.responseDTO.Sem01ResultResponseDTO;
import com.kavinda.examresult.dto.responseDTO.Sem03ResultResponseDTO;
import com.kavinda.examresult.entity.Sem03ExamResult;
import com.kavinda.examresult.service.Semester03Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ExamResultConstants.SEMESTER_03_BASE_URL)
public class Semester03Controller {

    @Autowired
    private Semester03Service semester03Service;

    //Add new semester 03 exam result using student ID
    @PostMapping("/new-result")
    public Sem03ExamResult newSem03Result(@RequestBody Sem03ResultRequestDTO
                                                  sem03ResultRequestDTO){
        return semester03Service.newSemester03ExamResult(sem03ResultRequestDTO);
    }

    // Retrieve All semester 03 exam result by student index with student index and name
    @GetMapping("/all-student-result")
    public List<Sem03ResultResponseDTO> retrieveSem03AllResult (){
        return semester03Service.retrieveSem03AllResult();
    }

    // Retrieve all semester 03 exam result with student Index and student name by student index
    @GetMapping("/result-by-index/{index}")
    public List<Sem03ResultResponseDTO> retrieveSem03ResultByIndex(@PathVariable ("index") String studentIndex){
        return semester03Service.retrieveSem03ResultByIndex(studentIndex);
    }
}
