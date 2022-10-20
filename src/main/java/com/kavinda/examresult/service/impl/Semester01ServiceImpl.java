package com.kavinda.examresult.service.impl;

import com.kavinda.examresult.dto.requestDTO.Sem01ResultRequestDTO;
import com.kavinda.examresult.dto.responseDTO.Sem01ResultResponseDTO;
import com.kavinda.examresult.entity.Sem01ExamResult;
import com.kavinda.examresult.entity.Student;
import com.kavinda.examresult.repository.Semester01Repository;
import com.kavinda.examresult.service.Semester01Service;
import com.kavinda.examresult.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Semester01ServiceImpl implements Semester01Service {

    @Autowired
    private Semester01Repository semester01Repository;

    @Autowired
    private StudentService studentService;

    @Override
    public Sem01ExamResult newSemester01ExamResult(Sem01ResultRequestDTO
                                                           sem01ResultRequestDTO) {
        Student studentById = studentService.getStudentDetailsById(
                sem01ResultRequestDTO.getStudentId());
        Sem01ExamResult sem01ExamResult = new Sem01ExamResult(sem01ResultRequestDTO, studentById);
        return semester01Repository.save(sem01ExamResult);
    }

    @Override
    public List<Sem01ResultResponseDTO> retrieveSemester01ExamResults() {
        return semester01Repository.findAll().stream().map(
                this::mapSemester01ExamResultResponseDTO).collect(
                        Collectors.toList());
    }

    // Map Semester01ExamResultResponseDTO with Semester01ExamResult Entity
    private Sem01ResultResponseDTO mapSemester01ExamResultResponseDTO(
            Sem01ExamResult sem01ExamResult){
        Sem01ResultResponseDTO sem01ResultResponseDTO = new Sem01ResultResponseDTO();
        sem01ResultResponseDTO.setStudentIndex(sem01ExamResult.getStudent().getStudentIndex());
        sem01ResultResponseDTO.setStudentName(sem01ExamResult.getStudent().getStudentName());
        sem01ResultResponseDTO.setPersonalComputerApplications(sem01ExamResult.getPersonalComputerApplications());
        sem01ResultResponseDTO.setComputerHardware(sem01ExamResult.getComputerHardware());
        sem01ResultResponseDTO.setStructuredProgramming(sem01ExamResult.getStructuredProgramming());
        sem01ResultResponseDTO.setDataRepresentationAndOrganization(sem01ExamResult.getDataRepresentationAndOrganization());
        sem01ResultResponseDTO.setDatabaseManagementSystems(sem01ExamResult.getDatabaseManagementSystems());
        sem01ResultResponseDTO.setWebDevelopment(sem01ExamResult.getWebDevelopment());
        sem01ResultResponseDTO.setMathematicsForIT(sem01ExamResult.getMathematicsForIT());
        sem01ResultResponseDTO.setEnglishForTechnologyI(sem01ExamResult.getEnglishForTechnologyI());
        return sem01ResultResponseDTO;
    }
}
