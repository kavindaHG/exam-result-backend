package com.kavinda.examresult.entity;

import com.kavinda.examresult.dto.requestDTO.Sem01ResultRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sem01ExamResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resultId;
    private String personalComputerApplications;
    private String computerHardware;
    private String structuredProgramming;
    private String dataRepresentationAndOrganization;
    private String databaseManagementSystems;
    private String webDevelopment;
    private String mathematicsForIT;
    private String englishForTechnologyI;

    @JoinColumn(name = "fk_studentId")
    @OneToOne(cascade = CascadeType.ALL)
    private Student student;

    // Map Semester01ExamResultRequestDTO with Semester01ExamResult Entity
    public Sem01ExamResult(Sem01ResultRequestDTO sem01ResultRequestDTO, Student student){
        this.personalComputerApplications = sem01ResultRequestDTO.getPersonalComputerApplications();
        this.computerHardware = sem01ResultRequestDTO.getComputerHardware();
        this.structuredProgramming = sem01ResultRequestDTO.getStructuredProgramming();
        this.dataRepresentationAndOrganization = sem01ResultRequestDTO.getDataRepresentationAndOrganization();
        this.databaseManagementSystems = sem01ResultRequestDTO.getDatabaseManagementSystems();
        this.webDevelopment = sem01ResultRequestDTO.getWebDevelopment();
        this.mathematicsForIT = sem01ResultRequestDTO.getMathematicsForIT();
        this.englishForTechnologyI = sem01ResultRequestDTO.getEnglishForTechnologyI();
        this.student = student;
    }
}

