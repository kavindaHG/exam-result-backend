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

    // Add new semester 01 exam result using student Index Number
    @PostMapping("/new")
    public Sem01ExamResult newSem01Result(@RequestBody Sem01ResultRequestDTO
                                                  sem01ResultRequestDTO){
        return semester01Service.newSemester01ExamResult(sem01ResultRequestDTO);
    }

    // Retrieve All semester 01 exam result by student index with student index and name
    @GetMapping("/all")
    public List<Sem01ResultResponseDTO> retrieveSem01AllResult(){
        return semester01Service.retrieveSem01AllResult();
    }

    // Retrieve all semester 01 exam result with student Index and student name by student index
    @GetMapping("/:index/{index}")
    public List<Sem01ResultResponseDTO> retrieveSem01ResultByIndex(@PathVariable ("index") String studentIndex){
        return semester01Service.retrieveSem01ResultByIndex(studentIndex);
    }

}
