package com.kavinda.examresult.controller;

import com.kavinda.examresult.common.ExamResultConstants;
import com.kavinda.examresult.dto.requestDTO.Sem04ResultRequestDTO;
import com.kavinda.examresult.dto.responseDTO.Sem04ResultResponseDTO;
import com.kavinda.examresult.entity.Sem04ExamResult;
import com.kavinda.examresult.service.Semester04Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ExamResultConstants.SEMESTER_04_BASE_URL)
public class Semester04Controller {

    @Autowired
    private Semester04Service semester04Service;

    //Add new semester 04 exam result using student ID
    @PostMapping("/new")
    public Sem04ExamResult newSem04Result(@RequestBody Sem04ResultRequestDTO
                                                  sem04ResultRequestDTO){
        return semester04Service.newSemester04ExamResult(sem04ResultRequestDTO);
    }

    // Retrieve All semester 04 exam result by student index with student index and name
    @GetMapping("/all")
    public List<Sem04ResultResponseDTO> retrieveSem04AllResult(){
        return semester04Service.retrieveSem04AllResult();
    }

    // Retrieve semester 04 exam result and student details by student index number
    @GetMapping("/:index/{index}")
    public List<Sem04ResultResponseDTO> retrieveSem02ResultByIndex(@PathVariable ("index") String studentIndex){
        return semester04Service.retrieveSem02ResultByIndex(studentIndex);
    }
}
