package com.kavinda.examresult.service.impl;

import com.kavinda.examresult.dto.requestDTO.Sem04ResultRequestDTO;
import com.kavinda.examresult.dto.responseDTO.Sem04ResultResponseDTO;
import com.kavinda.examresult.entity.Sem04ExamResult;
import com.kavinda.examresult.entity.Student;
import com.kavinda.examresult.repository.Semester04Repository;
import com.kavinda.examresult.service.Semester04Service;
import com.kavinda.examresult.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class Semester04ServiceImpl implements Semester04Service {

    @Autowired
    private Semester04Repository semester04Repository;

    @Autowired
    private StudentService studentService;

    // Add new semester 04 exam result by student index number
    @Override
    public Sem04ExamResult newSemester04ExamResult(Sem04ResultRequestDTO sem04ResultRequestDTO) {
        String serviceName = "newSemester04ExamResult";
        log.info(serviceName + "Is called");

        try {
            Student studentIndex = studentService.getStudentDetailsByIndex(sem04ResultRequestDTO.getStudentIndex());
            Sem04ExamResult semester04ExamResult = new Sem04ExamResult(sem04ResultRequestDTO, studentIndex);
            return semester04Repository.save(semester04ExamResult);
        }catch (Exception e){
            return null;
        }
    }

    // Retrieve all semester 04 exam result details
    @Override
    public List<Sem04ResultResponseDTO> retrieveSem04AllResult() {
        String serviceName = "retrieveSem04AllResult";
        log.info(serviceName + "Is called");

        try {
            return semester04Repository.findAll().stream().map(
                    this::sem04ResultResponseDTO).collect(Collectors.toList());
        }catch (FileSystemNotFoundException notFoundException){
            return null;
        }
    }

    // Retrieve all semester 04 exam result with student Index and student name by student index
    @Override
    public List<Sem04ResultResponseDTO> retrieveSem02ResultByIndex(String studentIndex) {
        String serviceName = "retrieveSem02ResultByIndex";
        log.info(serviceName + "Is called");

        try {
            return semester04Repository.findAllByStudentStudentIndex(studentIndex).stream().map(
                    this::sem04ResultResponseDTO).collect(Collectors.toList());
        }catch (FileSystemNotFoundException notFoundException){
            return null;
        }
    }

    // Map Semester01ExamResultResponseDTO with Semester01ExamResult Entity
    private Sem04ResultResponseDTO sem04ResultResponseDTO(Sem04ExamResult  sem04ExamResult){
        Sem04ResultResponseDTO sem04ResultResponseDTO = new Sem04ResultResponseDTO();
        sem04ResultResponseDTO.setStudentIndex(sem04ExamResult.getStudent().getStudentIndex());
        sem04ResultResponseDTO.setStudentName(sem04ExamResult.getStudent().getStudentName());
        sem04ResultResponseDTO.setEnterpriseArchitecture(sem04ExamResult.getEnterpriseArchitecture());
        sem04ResultResponseDTO.setComputerArchitecture(sem04ExamResult.getComputerArchitecture());
        sem04ResultResponseDTO.setFreeAndOpenSourceSoftware(sem04ExamResult.getFreeAndOpenSourceSoftware());
        sem04ResultResponseDTO.setWebApplicationDevelopment(sem04ExamResult.getWebApplicationDevelopment());
        sem04ResultResponseDTO.setEnglishForTechnologyIV(sem04ExamResult.getEnglishForTechnologyIV());
        sem04ResultResponseDTO.setIndividualProject(sem04ExamResult.getIndividualProject());
        return sem04ResultResponseDTO;
    }
}
