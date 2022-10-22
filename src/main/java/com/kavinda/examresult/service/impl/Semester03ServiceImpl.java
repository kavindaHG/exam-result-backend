package com.kavinda.examresult.service.impl;

import com.kavinda.examresult.dto.requestDTO.Sem03ResultRequestDTO;
import com.kavinda.examresult.dto.responseDTO.Sem03ResultResponseDTO;
import com.kavinda.examresult.entity.Sem03ExamResult;
import com.kavinda.examresult.entity.Student;
import com.kavinda.examresult.repository.Semester03Repository;
import com.kavinda.examresult.service.Semester03Service;
import com.kavinda.examresult.service.StudentService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class Semester03ServiceImpl implements Semester03Service {

    @Autowired
    private Semester03Repository semester03Repository;

    @Autowired
    private StudentService studentService;

    // Add new semester 03 exam result by student index number\
    @Override
    public Sem03ExamResult newSemester03ExamResult(Sem03ResultRequestDTO sem03ResultRequestDTO) {
        String serviceName = "newSemester03ExamResult";
        log.info(serviceName + "Is called");

        try {
            Student studentIndex = studentService.getStudentDetailsByIndex(sem03ResultRequestDTO.getStudentIndex());
            Sem03ExamResult sem03ExamResult = new Sem03ExamResult(sem03ResultRequestDTO, studentIndex);
            return semester03Repository.save(sem03ExamResult);
        }catch (Exception e){
            return null;
        }
    }

    // Retrieve all semester 01 exam result details
    @Override
    public List<Sem03ResultResponseDTO> retrieveSem03AllResult() {
        String serviceName = "retrieveSem03AllResult";
        log.info(serviceName + "Is called");

        try {
            return semester03Repository.findAll().stream().map(
                    this::mapSemester02ExamResultResponseDTO).collect(Collectors.toList());
        }catch (FileSystemNotFoundException fileSystemNotFoundException){
            return null;
        }
    }

    // Retrieve all semester 01 exam result with student Index and student name by student index
    @Override
    public List<Sem03ResultResponseDTO> retrieveSem03ResultByIndex(String studentIndex) {
        String serviceName = "retrieveSem03ResultByIndex";
        log.info(serviceName + "Is called");
        try {
            return semester03Repository.findAllByStudentStudentIndex(studentIndex).stream().map(
                    this::mapSemester02ExamResultResponseDTO).collect(Collectors.toList());
        }catch (FileSystemNotFoundException fileSystemNotFoundException){
            return null;
        }
    }

    // Map Semester01ExamResultResponseDTO with Semester01ExamResult Entity
    private Sem03ResultResponseDTO mapSemester02ExamResultResponseDTO(Sem03ExamResult sem03ExamResult){
        Sem03ResultResponseDTO sem03ResultResponseDTO = new Sem03ResultResponseDTO();
        sem03ResultResponseDTO.setStudentIndex(sem03ExamResult.getStudent().getStudentIndex());
        sem03ResultResponseDTO.setStudentName(sem03ExamResult.getStudent().getStudentName());
        sem03ResultResponseDTO.setOperatingSystemsAndComputerSecurity(sem03ExamResult.getOperatingSystemsAndComputerSecurity());
        sem03ResultResponseDTO.setProjectManagement(sem03ExamResult.getProjectManagement());
        sem03ResultResponseDTO.setEconomicsForIT(sem03ExamResult.getEconomicsForIT());
        sem03ResultResponseDTO.setRapidApplicationDevelopment(sem03ExamResult.getRapidApplicationDevelopment());
        sem03ResultResponseDTO.setPrinciplesOfSoftwareEngineering(sem03ExamResult.getPrinciplesOfSoftwareEngineering());
        sem03ResultResponseDTO.setObjectOrientedAnalysisAndDesign(sem03ExamResult.getObjectOrientedAnalysisAndDesign());
        sem03ResultResponseDTO.setEnglishForTechnologyIII(sem03ExamResult.getEnglishForTechnologyIII());
        sem03ResultResponseDTO.setGroupProject(sem03ExamResult.getGroupProject());
        return sem03ResultResponseDTO;
    }
}


