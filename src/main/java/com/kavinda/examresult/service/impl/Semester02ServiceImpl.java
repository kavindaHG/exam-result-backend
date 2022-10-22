package com.kavinda.examresult.service.impl;

import com.kavinda.examresult.dto.requestDTO.Sem02ResultRequestDTO;
import com.kavinda.examresult.dto.responseDTO.Sem02ResultResponseDTO;
import com.kavinda.examresult.entity.Sem02ExamResult;
import com.kavinda.examresult.entity.Student;
import com.kavinda.examresult.repository.Semester02Repository;
import com.kavinda.examresult.service.Semester02Service;
import com.kavinda.examresult.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class Semester02ServiceImpl implements Semester02Service {

    @Autowired
    private Semester02Repository semester02Repository;

    @Autowired
    private StudentService studentService;

    // Add new semester 02 exam result by student index number
    @Override
    public Sem02ExamResult newSemester02ExamResult(Sem02ResultRequestDTO sem02ResultRequestDTO) {
        String serviceName = "newSemester02ExamResult";
        log.info(serviceName + "Is Called");

        try {
            Student studentByIndex = studentService.getStudentDetailsByIndex(sem02ResultRequestDTO.getStudentIndex());
            Sem02ExamResult sem02ExamResult = new Sem02ExamResult(sem02ResultRequestDTO, studentByIndex);
            return semester02Repository.save(sem02ExamResult);
        }catch (Exception e){
            return null;
        }
    }

    // Retrieve all semester 02 exam result details
    @Override
    public List<Sem02ResultResponseDTO> retrieveSem02AllResult() {
        String serviceName = "retrieveSem02AllResult";
        log.info(serviceName + "Is Called");

        try{
            return semester02Repository.findAll().stream().map(
                    this::mapSemester02ExamResultResponseDTO).collect(Collectors.toList());
        }catch (FileSystemNotFoundException fileSystemNotFoundException){
            return null;
        }
    }

    // Retrieve all semester 02 exam result with student Index and student name by student index
    @Override
    public List<Sem02ResultResponseDTO> retrieveSem02ResultByIndex(String studentIndex) {

        String serviceName = "retrieveSem02ResultByIndex";
        log.info(serviceName + "Is Called");

        try {
            return semester02Repository.findAllByStudentStudentIndex(studentIndex).stream().map(
                    this::mapSemester02ExamResultResponseDTO).collect(Collectors.toList());
        }catch (FileSystemNotFoundException fileSystemNotFoundException){
            return null;
        }
    }

    // Map Semester01ExamResultResponseDTO with Semester01ExamResult Entity
    private Sem02ResultResponseDTO mapSemester02ExamResultResponseDTO(
            Sem02ExamResult sem02ExamResult){
        Sem02ResultResponseDTO sem02ResultResponseDTO = new Sem02ResultResponseDTO();
        sem02ResultResponseDTO.setStudentIndex(sem02ExamResult.getStudent().getStudentIndex());
        sem02ResultResponseDTO.setStudentName(sem02ExamResult.getStudent().getStudentName());
        sem02ResultResponseDTO.setObjectOrientedProgramming(sem02ExamResult.getObjectOrientedProgramming());
        sem02ResultResponseDTO.setGraphicsAndMultimedia(sem02ExamResult.getGraphicsAndMultimedia());
        sem02ResultResponseDTO.setDataStructuresAndAlgorithms(sem02ExamResult.getDataStructuresAndAlgorithms());
        sem02ResultResponseDTO.setSystemAnalysisAndDesign(sem02ExamResult.getSystemAnalysisAndDesign());
        sem02ResultResponseDTO.setDataCommunicationAndNetworking(sem02ExamResult.getDataCommunicationAndNetworking());
        sem02ResultResponseDTO.setStatisticsForIT(sem02ExamResult.getStatisticsForIT());
        sem02ResultResponseDTO.setEnglishForTechnologyII(sem02ExamResult.getEnglishForTechnologyII());
        sem02ResultResponseDTO.setHumanValuesAndProfessionalEthics(sem02ExamResult.getHumanValuesAndProfessionalEthics());
        return sem02ResultResponseDTO;
    }
}
