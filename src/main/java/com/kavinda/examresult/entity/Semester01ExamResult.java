package com.kavinda.examresult.entity;

import com.kavinda.examresult.dto.requestDTO.Semester01ExamResultRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Semester01ExamResult {

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

    public Semester01ExamResult(Semester01ExamResultRequestDTO semester01ExamResultRequestDTO, Student student){
        this.personalComputerApplications = semester01ExamResultRequestDTO.getPersonalComputerApplications();
        this.computerHardware = semester01ExamResultRequestDTO.getComputerHardware();
        this.structuredProgramming = semester01ExamResultRequestDTO.getStructuredProgramming();
        this.dataRepresentationAndOrganization = semester01ExamResultRequestDTO.getDataRepresentationAndOrganization();
        this.databaseManagementSystems = semester01ExamResultRequestDTO.getDatabaseManagementSystems();
        this.webDevelopment = semester01ExamResultRequestDTO.getWebDevelopment();
        this.mathematicsForIT = semester01ExamResultRequestDTO.getMathematicsForIT();
        this.englishForTechnologyI = semester01ExamResultRequestDTO.getEnglishForTechnologyI();
        this.student = student;
    }
}

