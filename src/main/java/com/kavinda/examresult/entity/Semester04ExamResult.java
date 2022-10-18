package com.kavinda.examresult.entity;

import com.kavinda.examresult.dto.requestDTO.Semester04ExamResultRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Semester04ExamResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resultId;
    private String computerArchitecture;
    private String enterpriseArchitecture;
    private String freeAndOpenSourceSoftware;
    private String mobileApplicationDevelopment;
    private String professionalIssuesInIT;
    private String webApplicationDevelopment;
    private String englishForTechnologyIV;
    private String individualProject;

    @JoinColumn(name = "fk_studentId")
    @OneToOne(cascade = CascadeType.ALL)
    private Student student;

    public Semester04ExamResult(Semester04ExamResultRequestDTO semester04ExamResultRequestDTO, Student student){
        this.computerArchitecture = semester04ExamResultRequestDTO.getComputerArchitecture();
        this.enterpriseArchitecture = semester04ExamResultRequestDTO.getEnterpriseArchitecture();
        this.freeAndOpenSourceSoftware = semester04ExamResultRequestDTO.getFreeAndOpenSourceSoftware();
        this.mobileApplicationDevelopment = semester04ExamResultRequestDTO.getMobileApplicationDevelopment();
        this.professionalIssuesInIT = semester04ExamResultRequestDTO.getProfessionalIssuesInIT();
        this.webApplicationDevelopment = semester04ExamResultRequestDTO.getWebApplicationDevelopment();
        this.englishForTechnologyIV = semester04ExamResultRequestDTO.getEnglishForTechnologyIV();
        this.individualProject = semester04ExamResultRequestDTO.getIndividualProject();
        this.student = student;
    }
}
