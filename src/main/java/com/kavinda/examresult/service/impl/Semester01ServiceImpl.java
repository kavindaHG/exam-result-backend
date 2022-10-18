package com.kavinda.examresult.service.impl;

import com.kavinda.examresult.dto.requestDTO.Semester01ExamResultRequestDTO;
import com.kavinda.examresult.dto.responseDTO.Semester01ExamResultResponseDTO;
import com.kavinda.examresult.entity.Semester01ExamResult;
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
    public Semester01ExamResult addNewSemester01ExamResultWithStudentId(Semester01ExamResultRequestDTO
                                                                                    semester01ExamResultRequestDTO) {
        Student studentById = studentService.retrieveStudentDetailsByStudentId(semester01ExamResultRequestDTO.getStudentId());
        Semester01ExamResult semester01ExamResult = new Semester01ExamResult(semester01ExamResultRequestDTO, studentById);
        return semester01Repository.save(semester01ExamResult);
    }

    @Override
    public List<Semester01ExamResultResponseDTO> retrieveAllSemester01ExamResultsWithStudentIndexAndName() {
        return semester01Repository.findAll().stream().map(
                this::mapSemester01ExamResultEntityAndStudentEntityToSemester01ExamResultResponseDTO).collect(Collectors.toList());
    }

    private Semester01ExamResultResponseDTO mapSemester01ExamResultEntityAndStudentEntityToSemester01ExamResultResponseDTO(
            Semester01ExamResult semester01ExamResult){
        Semester01ExamResultResponseDTO semester01ExamResultResponseDTO = new Semester01ExamResultResponseDTO();
        semester01ExamResultResponseDTO.setStudentIndex(semester01ExamResult.getStudent().getStudentIndex());
        semester01ExamResultResponseDTO.setStudentName(semester01ExamResult.getStudent().getStudentName());
        semester01ExamResultResponseDTO.setPersonalComputerApplications(semester01ExamResult.getPersonalComputerApplications());
        semester01ExamResultResponseDTO.setComputerHardware(semester01ExamResult.getComputerHardware());
        semester01ExamResultResponseDTO.setStructuredProgramming(semester01ExamResult.getStructuredProgramming());
        semester01ExamResultResponseDTO.setDataRepresentationAndOrganization(semester01ExamResult.getDataRepresentationAndOrganization());
        semester01ExamResultResponseDTO.setDatabaseManagementSystems(semester01ExamResult.getDatabaseManagementSystems());
        semester01ExamResultResponseDTO.setWebDevelopment(semester01ExamResult.getWebDevelopment());
        semester01ExamResultResponseDTO.setMathematicsForIT(semester01ExamResult.getMathematicsForIT());
        semester01ExamResultResponseDTO.setEnglishForTechnologyI(semester01ExamResult.getEnglishForTechnologyI());
        return semester01ExamResultResponseDTO;
    }
}
