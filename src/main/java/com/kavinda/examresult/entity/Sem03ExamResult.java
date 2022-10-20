package com.kavinda.examresult.entity;

import com.kavinda.examresult.dto.requestDTO.Sem03ResultResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sem03ExamResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resultId;
    private String operatingSystemsAndComputerSecurity;
    private String projectManagement;
    private String economicsForIT;
    private String rapidApplicationDevelopment;
    private String principlesOfSoftwareEngineering;
    private String objectOrientedAnalysisAndDesign;
    private String englishForTechnologyIII;
    private String groupProject;

    @JoinColumn(name = "fk_studentId")
    @OneToOne(cascade = CascadeType.ALL)
    private Student student;

    // Map Semester03ExamResultRequestDTO with Semester03ExamResult Entity
    public Sem03ExamResult(Sem03ResultResponseDTO sem03ResultResponseDTO, Student student){
        this.operatingSystemsAndComputerSecurity = sem03ResultResponseDTO.getOperatingSystemsAndComputerSecurity();
        this.projectManagement = sem03ResultResponseDTO.getProjectManagement();
        this.economicsForIT = sem03ResultResponseDTO.getEconomicsForIT();
        this.rapidApplicationDevelopment = sem03ResultResponseDTO.getRapidApplicationDevelopment();
        this.principlesOfSoftwareEngineering = sem03ResultResponseDTO.getPrinciplesOfSoftwareEngineering();
        this.objectOrientedAnalysisAndDesign = sem03ResultResponseDTO.getObjectOrientedAnalysisAndDesign();
        this.englishForTechnologyIII = sem03ResultResponseDTO.getEnglishForTechnologyIII();
        this.groupProject = sem03ResultResponseDTO.getGroupProject();
        this.student = student;
    }
}
