package com.kavinda.examresult.entity;

import com.kavinda.examresult.dto.requestDTO.Sem03ResultRequestDTO;
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
    public Sem03ExamResult(Sem03ResultRequestDTO sem03ResultRequestDTO, Student student){
        this.operatingSystemsAndComputerSecurity = sem03ResultRequestDTO.getOperatingSystemsAndComputerSecurity();
        this.projectManagement = sem03ResultRequestDTO.getProjectManagement();
        this.economicsForIT = sem03ResultRequestDTO.getEconomicsForIT();
        this.rapidApplicationDevelopment = sem03ResultRequestDTO.getRapidApplicationDevelopment();
        this.principlesOfSoftwareEngineering = sem03ResultRequestDTO.getPrinciplesOfSoftwareEngineering();
        this.objectOrientedAnalysisAndDesign = sem03ResultRequestDTO.getObjectOrientedAnalysisAndDesign();
        this.englishForTechnologyIII = sem03ResultRequestDTO.getEnglishForTechnologyIII();
        this.groupProject = sem03ResultRequestDTO.getGroupProject();
        this.student = student;
    }
}
