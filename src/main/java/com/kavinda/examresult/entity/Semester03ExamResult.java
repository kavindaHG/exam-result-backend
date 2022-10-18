package com.kavinda.examresult.entity;

import com.kavinda.examresult.dto.requestDTO.Semester03ExamResultRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Semester03ExamResult {

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

    public Semester03ExamResult(Semester03ExamResultRequestDTO semester03ExamResultRequestDTO, Student student){
        this.operatingSystemsAndComputerSecurity = semester03ExamResultRequestDTO.getOperatingSystemsAndComputerSecurity();
        this.projectManagement = semester03ExamResultRequestDTO.getProjectManagement();
        this.economicsForIT = semester03ExamResultRequestDTO.getEconomicsForIT();
        this.rapidApplicationDevelopment = semester03ExamResultRequestDTO.getRapidApplicationDevelopment();
        this.principlesOfSoftwareEngineering = semester03ExamResultRequestDTO.getPrinciplesOfSoftwareEngineering();
        this.objectOrientedAnalysisAndDesign = semester03ExamResultRequestDTO.getObjectOrientedAnalysisAndDesign();
        this.englishForTechnologyIII = semester03ExamResultRequestDTO.getEnglishForTechnologyIII();
        this.groupProject = semester03ExamResultRequestDTO.getGroupProject();
        this.student = student;
    }
}
